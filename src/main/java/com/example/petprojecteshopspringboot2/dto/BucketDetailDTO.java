package com.example.petprojecteshopspringboot2.dto;

import com.example.petprojecteshopspringboot2.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class BucketDetailDTO {
    private String title;
    private Long productId;
    private BigDecimal price;
    private BigDecimal amount;
    private Double sum;

    public BucketDetailDTO(Product product) {
        if (product.getPrice() == null) {
            Logger log = LoggerFactory.getLogger(BucketDetailDTO.class);
            log.warn("Product with ID {} has null price", product.getId());
        }
        this.title = product.getTitle();
        this.productId = product.getId();
        this.price = product.getPrice() != null ? product.getPrice()
                : BigDecimal.ZERO;
        this.amount = BigDecimal.ONE;
        this.sum = this.price.doubleValue();
    }


    public BucketDetailDTO(String title, Long productId, BigDecimal price,
                           BigDecimal amount, Double sum) {
        this.title = title;
        this.productId = productId;
        this.price = price;
        this.amount = amount;
        this.sum = sum;
    }

    public BucketDetailDTO() {
    }

    public static BucketDetailDTOBuilder builder() {
        return new BucketDetailDTOBuilder();
    }

    public String getTitle() {
        return this.title;
    }

    public Long getProductId() {
        return this.productId;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Double getSum() {
        return this.sum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BucketDetailDTO)) return false;
        final BucketDetailDTO other = (BucketDetailDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$productId = this.getProductId();
        final Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
        final Object this$sum = this.getSum();
        final Object other$sum = other.getSum();
        if (this$sum == null ? other$sum != null : !this$sum.equals(other$sum)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BucketDetailDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $amount = this.getAmount();
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        final Object $sum = this.getSum();
        result = result * PRIME + ($sum == null ? 43 : $sum.hashCode());
        return result;
    }

    public String toString() {
        return "BucketDetailDTO(title=" + this.getTitle() + ", productId="
                + this.getProductId() + ", price=" + this.getPrice() +
                ", amount=" + this.getAmount() + ", sum=" + this.getSum() + ")";
    }

    public static class BucketDetailDTOBuilder {
        private String title;
        private Long productId;
        private BigDecimal price;
        private BigDecimal amount;
        private Double sum;

        BucketDetailDTOBuilder() {
        }

        public BucketDetailDTOBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BucketDetailDTOBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public BucketDetailDTOBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public BucketDetailDTOBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public BucketDetailDTOBuilder sum(Double sum) {
            this.sum = sum;
            return this;
        }

        public BucketDetailDTO build() {
            return new BucketDetailDTO(this.title, this.productId, this.price,
                    this.amount, this.sum);
        }

        public String toString() {
            return "BucketDetailDTO.BucketDetailDTOBuilder(title=" + this.title +
                    ", productId=" + this.productId + ", price=" + this.price +
                    ", amount=" + this.amount + ", sum=" + this.sum + ")";
        }
    }
}
