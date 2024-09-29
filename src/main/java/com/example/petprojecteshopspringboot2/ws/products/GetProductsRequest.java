package com.example.petprojecteshopspringboot2.ws.products;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name"
})
@XmlRootElement(name = "getProductsRequest")
public class GetProductsRequest {
    @XmlElement(required = true)
    protected String title;
    protected double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double value) {
        this.price = value;
    }
}
