package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.dao.ProductRepository;
import com.example.petprojecteshopspringboot2.domain.Bucket;
import com.example.petprojecteshopspringboot2.domain.Product;
import com.example.petprojecteshopspringboot2.domain.User;
import com.example.petprojecteshopspringboot2.dto.ProductDTO;
import com.example.petprojecteshopspringboot2.mapper.ProductMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final BucketService bucketService;
    private final SimpMessagingTemplate template;

    public ProductServiceImpl(ProductMapper mapper,
                              ProductRepository productRepository,
                              UserService userService,
                              BucketService bucketService,
                              SimpMessagingTemplate template) {
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.userService = userService;
        this.bucketService = bucketService;
        this.template = template;
    }

    @Override
    public List<ProductDTO> getAll() {
        return mapper.fromProductList(productRepository.findAll());
    }

    @Override
    public ProductDTO convertToDTO(Product product) {
        return mapper.fromProduct(product);
    }

    @Override
    public Product convertToEntity(ProductDTO productDTO) {
        return mapper.toProduct(productDTO);
    }

    @Override
    @Transactional
    public void addToUserBucket(Long productId, String username) {
        User user = userService.findByName(username);
        if (user == null) {
            throw new RuntimeException("User not found - " + username);
        }
        Bucket bucket = user.getBucket();
        if (bucket == null) {
            Bucket newBucket = bucketService.createBucket(user,
                    Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);
        } else {
            bucketService.addProducts(bucket, Collections.singletonList(productId));
        }
    }

    @Override
    @Transactional
    public void addProduct(ProductDTO dto) {
        Product product = mapper.toProduct(dto);
        Product savedProduct = productRepository.save(product);
        template.convertAndSend("/topic/products",
                mapper.fromProduct(savedProduct));
    }

    @Override
    public ProductDTO getById(Long id) {
       Product product = productRepository.findById(id).orElse(new Product());
       return mapper.fromProduct(product);
    }

}
