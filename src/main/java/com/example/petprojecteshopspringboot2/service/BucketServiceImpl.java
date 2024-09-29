package com.example.petprojecteshopspringboot2.service;


import com.example.petprojecteshopspringboot2.dao.ProductRepository;
import com.example.petprojecteshopspringboot2.dao.UserRepository;
import com.example.petprojecteshopspringboot2.domain.*;
import com.example.petprojecteshopspringboot2.dao.BucketRepository;
import com.example.petprojecteshopspringboot2.dto.BucketDTO;
import com.example.petprojecteshopspringboot2.dto.BucketDetailDTO;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService {
    private final BucketRepository bucketRepository;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final OrderService orderService;

    public BucketServiceImpl(BucketRepository bucketRepository, ProductRepository productRepository, UserService userService, OrderService orderService) {
        this.bucketRepository = bucketRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    @Transactional
    public Bucket createBucket(User user, List<Long> productIds) {
        Bucket bucket = new Bucket();
        bucket.setUser(user);
        List<Product> productList = getCollectRefProductsByIds(productIds);
        bucket.setProducts(productList);
        return bucketRepository.save(bucket);
    }

    private List<Product> getCollectRefProductsByIds(List<Long> productIds) {
        return productIds.stream()
                .map(productRepository::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public void addProducts(Bucket bucket, List<Long> productIds) {
        List<Product> products = bucket.getProducts();
        List<Product> newProductList = products ==
                null ? new ArrayList<>() : new ArrayList<>(products);
        newProductList.addAll(getCollectRefProductsByIds(productIds));
        bucket.setProducts(newProductList);
        bucketRepository.save(bucket);
    }

    @Override
    @Transactional
    public BucketDTO getBucketByUser(String name) {
        User user = userService.findByName(name);
        if (user == null || user.getBucket() == null) {
            return new BucketDTO();
        }
        BucketDTO bucketDTO = new BucketDTO();
        Map<Long, BucketDetailDTO> mapByProductId = new HashMap<>();

        List<Product> products = user.getBucket().getProducts();
        for (Product product : products) {
            BucketDetailDTO detail = mapByProductId.get(product.getId());
            if (detail == null) {
                mapByProductId.put(product.getId(), new BucketDetailDTO(product));
            } else {
                detail.setAmount(detail.getAmount().add(new BigDecimal("1.0")));
                detail.setSum(detail.getSum() + Double.parseDouble(product.getPrice().toString()));
            }
        }
        bucketDTO.setBucketDetails(new ArrayList<>(mapByProductId.values()));
        bucketDTO.aggregate();
        return bucketDTO;
    }

    @Override
    @Transactional
    public void commitBucketToOrder(String username) {
        User user = userService.findByName(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Bucket bucket = user.getBucket();
        if (bucket == null || bucket.getProducts().isEmpty()) {
            return;
        }
        Order order = new Order();
        order.setStatus(OrderStatus.NEW);
        order.setUser(user);

        Map<Product, Long> productWithAmount = bucket.getProducts().stream()
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        List<OrderDetails> orderDetails = productWithAmount.entrySet().stream()
                .map(pair -> {
                    Product product = pair.getKey();
                    Long amount = pair.getValue();
                    BigDecimal price = product.getPrice() != null ?
                            new BigDecimal(product.getPrice().toString()) : BigDecimal.ZERO;

                    OrderDetails detail = new OrderDetails(order, product, amount);
                    detail.setPrice(price);

                    return detail;
                })
                .toList();

        orderDetails.forEach(order::addDetail);

        BigDecimal total = orderDetails.stream()
                .filter(detail -> detail.getPrice() != null && detail.getAmount() != null)
                .map(detail -> detail.getPrice().multiply(detail.getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setDetails(orderDetails);
        order.setSum(total);
        order.setAddress("none");

        orderService.saveOrder(order);
        bucket.getProducts().clear();
        bucketRepository.save(bucket);
    }
}
