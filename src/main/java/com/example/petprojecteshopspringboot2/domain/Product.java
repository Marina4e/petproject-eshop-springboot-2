package com.example.petprojecteshopspringboot2.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    private static final String SEQ_NAME = "product_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String title;
    private BigDecimal price;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Product(Long id, String title, BigDecimal price, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categories = categories;
    }

    public Product() {
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$categories = this.getCategories();
        final Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $categories = this.getCategories();
        result = result * PRIME + ($categories == null ? 43 : $categories.hashCode());
        return result;
    }

    public String toString() {
        return "Product(id=" + this.getId() + ", title=" + this.getTitle() + ", price=" + this.getPrice() + ", categories=" + this.getCategories() + ")";
    }

    public static class ProductBuilder {
        private Long id;
        private String title;
        private BigDecimal price;
        private List<Category> categories;

        ProductBuilder() {
        }

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder categories(List<Category> categories) {
            this.categories = categories;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.title, this.price, this.categories);
        }

        public String toString() {
            return "Product.ProductBuilder(id=" + this.id + ", title=" + this.title + ", price=" + this.price + ", categories=" + this.categories + ")";
        }
    }
}
