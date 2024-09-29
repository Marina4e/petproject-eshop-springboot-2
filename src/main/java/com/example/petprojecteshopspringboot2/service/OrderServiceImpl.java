package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.config.OrderIntegrationConfig;
import com.example.petprojecteshopspringboot2.dao.OrderRepository;
import com.example.petprojecteshopspringboot2.domain.Order;
import com.example.petprojecteshopspringboot2.dto.OrderIntegrationDto;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderIntegrationConfig integrationConfig;


    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderIntegrationConfig integrationConfig) {
        this.orderRepository = orderRepository;
        this.integrationConfig = integrationConfig;
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        sendIntegrationNotify(savedOrder);
    }

    private void sendIntegrationNotify(Order order) {
        OrderIntegrationDto dto = new OrderIntegrationDto();
        dto.setUsername(order.getUser().getName());
        dto.setAddress(order.getAddress());
        dto.setOrderId(order.getId());
        List<OrderIntegrationDto.OrderDetailsDto> details = order.getDetails().stream()
                .map(OrderIntegrationDto.OrderDetailsDto::new).collect(Collectors.toList());
        dto.setDetails(details);

        Message<OrderIntegrationDto> message = MessageBuilder.withPayload(dto)
                .setHeader("Content-type", "application/json")
                .build();

        integrationConfig.getOrdersChannel().send(message);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
