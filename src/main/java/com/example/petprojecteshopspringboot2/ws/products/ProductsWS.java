package com.example.petprojecteshopspringboot2.ws.products;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productsWS", propOrder = {
        "id",
        "title",
        "price"
})
public class ProductsWS {

    protected long id;
    @XmlElement(required = true)
    protected String title;
    protected double price;

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

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

    public void add(ProductsWS productWs) {
        this.id += productWs.getId();
    }
}
