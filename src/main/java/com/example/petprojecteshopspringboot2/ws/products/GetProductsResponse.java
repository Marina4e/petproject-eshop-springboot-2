package com.example.petprojecteshopspringboot2.ws.products;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "products"
})
@XmlRootElement(name = "getProductsResponse")
public class GetProductsResponse {

    @XmlElement(required = true)
    protected ProductsWS products;

    public ProductsWS getProducts() {
        return products;
    }

    public void setProducts(ProductsWS value) {
        this.products = value;
    }
}
