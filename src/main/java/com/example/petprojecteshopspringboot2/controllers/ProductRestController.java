package com.example.petprojecteshopspringboot2.controllers;


import com.example.petprojecteshopspringboot2.dto.ProductDTO;
import com.example.petprojecteshopspringboot2.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }


    @PostMapping("/")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
