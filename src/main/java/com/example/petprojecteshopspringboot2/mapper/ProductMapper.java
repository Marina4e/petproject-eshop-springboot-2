package com.example.petprojecteshopspringboot2.mapper;

import com.example.petprojecteshopspringboot2.domain.Product;
import com.example.petprojecteshopspringboot2.dto.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO dto);

    @InheritInverseConfiguration
    ProductDTO fromProduct(Product product);

    List<Product> toProductList(List<ProductDTO> productDTOS);

    List<ProductDTO> fromProductList(List<Product> products);
}
