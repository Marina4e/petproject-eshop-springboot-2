package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.Product;
import com.example.petprojecteshopspringboot2.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    ProductDTO convertToDTO(Product product);

    Product convertToEntity(ProductDTO productDTO);

    void addToUserBucket(Long productId, String username);

    void addProduct(ProductDTO dto);

    ProductDTO getById(Long id);


}
