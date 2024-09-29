package com.example.petprojecteshopspringboot2.service;


import com.example.petprojecteshopspringboot2.dao.ProductRepository;
import com.example.petprojecteshopspringboot2.dto.ProductDTO;
import com.example.petprojecteshopspringboot2.mapper.ProductMapper;
import com.example.petprojecteshopspringboot2.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getByIdTest() {
        Long productId = 1L;

        Product mockProduct = new Product();
        mockProduct.setId(productId);
        mockProduct.setTitle("Test Product");
        mockProduct.setPrice(new BigDecimal("100.00"));

        ProductDTO mockProductDTO = new ProductDTO(productId, "Test Product",
                new BigDecimal("100.00"));

        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));

        when(productMapper.fromProduct(mockProduct)).thenReturn(mockProductDTO);

        ProductDTO actualProductDTO = productService.getById(productId);

        assertEquals(mockProductDTO, actualProductDTO);
    }
}
