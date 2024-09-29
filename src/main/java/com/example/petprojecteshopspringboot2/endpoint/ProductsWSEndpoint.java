package com.example.petprojecteshopspringboot2.endpoint;

import com.example.petprojecteshopspringboot2.dto.ProductDTO;
import com.example.petprojecteshopspringboot2.service.ProductService;
import com.example.petprojecteshopspringboot2.ws.products.GetProductsRequest;
import com.example.petprojecteshopspringboot2.ws.products.GetProductsResponse;
import com.example.petprojecteshopspringboot2.ws.products.ProductsWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ProductsWSEndpoint {
    public static final String NAMESPACE_URL = "http://example.com/petprojecteshopspringboot2/ws/products";
    private final ProductService productService;

    @Autowired
    public ProductsWSEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProductsWS(@RequestPayload GetProductsRequest request) {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll().forEach(dto -> response.getProducts().add(createProductWs(dto)));
        return response;
    }

    private ProductsWS createProductWs(ProductDTO dto) {
        ProductsWS ws = new ProductsWS();
        ws.setId(dto.getId());
        ws.setPrice(Double.parseDouble(dto.getPrice().toString()));
        ws.setTitle(dto.getTitle());
        return ws;
    }
}
