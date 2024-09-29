package com.example.petprojecteshopspringboot2.dao;

import com.example.petprojecteshopspringboot2.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
