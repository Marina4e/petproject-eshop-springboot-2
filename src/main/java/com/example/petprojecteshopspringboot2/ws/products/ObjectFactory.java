package com.example.petprojecteshopspringboot2.ws.products;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    public ProductsWS createProductsWS() {
        return new ProductsWS();
    }

    public GetProductsRequest createGetProductsRequest() {
        return new GetProductsRequest();
    }
}
