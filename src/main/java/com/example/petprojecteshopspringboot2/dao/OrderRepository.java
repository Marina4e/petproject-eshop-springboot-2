package com.example.petprojecteshopspringboot2.dao;

import com.example.petprojecteshopspringboot2.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
