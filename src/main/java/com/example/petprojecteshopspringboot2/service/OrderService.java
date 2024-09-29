package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.Order;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrder(Long id);
}
