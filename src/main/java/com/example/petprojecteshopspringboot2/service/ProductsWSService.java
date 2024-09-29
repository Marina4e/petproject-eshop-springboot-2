package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.ws.products.ProductsWS;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;

@Component
public class ProductsWSService {
    public ProductsWS generateProductsWS(String title, double price)
            throws DatatypeConfigurationException {
        ProductsWS productsWS = new ProductsWS();
        productsWS.setTitle(title);
        productsWS.setPrice(price);
        productsWS.getTitle();
        productsWS.getPrice();
        return productsWS;
    }
}