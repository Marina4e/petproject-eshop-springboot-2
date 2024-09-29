package com.example.petprojecteshopspringboot2.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String title;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public static ProductDTOBuilder builder() {
        return new ProductDTOBuilder();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO other = (ProductDTO) o;
        return this.id.equals(other.id) && this.title.equals(other.title) && this.price.equals(other.price);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductDTO(id=" + id + ", title=" + title + ", price=" + price + ")";
    }

    public static class ProductDTOBuilder {
        private Long id;
        private String title;
        private BigDecimal price;

        public ProductDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductDTOBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductDTOBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(id, title, price);
        }

        @Override
        public String toString() {
            return "ProductDTOBuilder(id=" + id + ", title=" + title + ", price=" + price + ")";
        }
    }
}
