package com.example.petprojecteshopspringboot2.domain;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orders_details")
public class OrderDetails {
    private static final String SEQ_NAME = "order_details_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    public OrderDetails(Long id, Order order, Product product, BigDecimal amount, BigDecimal price) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public OrderDetails(Order order, Product key, Long value) {
        this.order = order;
        this.product = key;
        this.amount = BigDecimal.valueOf(value);
        this.price = product.getPrice();  // Упростили преобразование
    }

    public OrderDetails() {

    }


    public static OrderDetailsBuilder builder() {
        return new OrderDetailsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Order getOrder() {
        return this.order;
    }

    public Product getProduct() {
        return this.product;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails)) return false;
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, product, amount, price);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderDetails;
    }


    public String toString() {
        return "OrderDetails(id=" + this.getId() + ", order=" + this.getOrder() + ", product=" + this.getProduct() + ", amount=" + this.getAmount() + ", price=" + this.getPrice() + ")";
    }

    public static class OrderDetailsBuilder {
        private Long id;
        private Order order;
        private Product product;
        private BigDecimal amount;
        private BigDecimal price;

        OrderDetailsBuilder() {
        }

        public OrderDetailsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderDetailsBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderDetailsBuilder product(Product product) {
            this.product = product;
            return this;
        }

        public OrderDetailsBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public OrderDetailsBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderDetails build() {
            return new OrderDetails(this.id, this.order, this.product, this.amount, this.price);
        }

        public String toString() {
            return "OrderDetails.OrderDetailsBuilder(id=" + this.id + ", order=" + this.order + ", product=" + this.product + ", amount=" + this.amount + ", price=" + this.price + ")";
        }
    }
}
