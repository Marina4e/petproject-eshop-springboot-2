package com.example.petprojecteshopspringboot2.dto;

import java.util.ArrayList;
import java.util.List;

public class BucketDTO {
    private int amountProducts;
    private Double sum;
    private List<BucketDetailDTO> bucketDetails = new ArrayList<>();

    public BucketDTO(int amountProducts, Double sum, List<BucketDetailDTO> bucketDetails) {
        this.amountProducts = amountProducts;
        this.sum = sum;
        this.bucketDetails = bucketDetails;
    }

    public BucketDTO() {
    }

    public static BucketDTOBuilder builder() {
        return new BucketDTOBuilder();
    }

    public void aggregate() {
        this.amountProducts = bucketDetails.size();
        this.sum = bucketDetails.stream()
                .map(BucketDetailDTO::getSum)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public int getAmountProducts() {
        return this.amountProducts;
    }

    public Double getSum() {
        return this.sum;
    }

    public List<BucketDetailDTO> getBucketDetails() {
        return this.bucketDetails;
    }

    public void setAmountProducts(int amountProducts) {
        this.amountProducts = amountProducts;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setBucketDetails(List<BucketDetailDTO> bucketDetails) {
        this.bucketDetails = bucketDetails;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BucketDTO)) return false;
        final BucketDTO other = (BucketDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getAmountProducts() != other.getAmountProducts()) return false;
        final Object this$sum = this.getSum();
        final Object other$sum = other.getSum();
        if (this$sum == null ? other$sum != null : !this$sum.equals(other$sum)) return false;
        final Object this$bucketDetails = this.getBucketDetails();
        final Object other$bucketDetails = other.getBucketDetails();
        if (this$bucketDetails == null ? other$bucketDetails != null : !this$bucketDetails.equals(other$bucketDetails))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BucketDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getAmountProducts();
        final Object $sum = this.getSum();
        result = result * PRIME + ($sum == null ? 43 : $sum.hashCode());
        final Object $bucketDetails = this.getBucketDetails();
        result = result * PRIME + ($bucketDetails == null ? 43 : $bucketDetails.hashCode());
        return result;
    }

    public String toString() {
        return "BucketDTO(amountProducts=" + this.getAmountProducts() + ", sum=" + this.getSum() + ", bucketDetails=" + this.getBucketDetails() + ")";
    }

    public static class BucketDTOBuilder {
        private int amountProducts;
        private Double sum;
        private List<BucketDetailDTO> bucketDetails;

        BucketDTOBuilder() {
        }

        public BucketDTOBuilder amountProducts(int amountProducts) {
            this.amountProducts = amountProducts;
            return this;
        }

        public BucketDTOBuilder sum(Double sum) {
            this.sum = sum;
            return this;
        }

        public BucketDTOBuilder bucketDetails(List<BucketDetailDTO> bucketDetails) {
            this.bucketDetails = bucketDetails;
            return this;
        }

        public BucketDTO build() {
            return new BucketDTO(this.amountProducts, this.sum, this.bucketDetails);
        }

        public String toString() {
            return "BucketDTO.BucketDTOBuilder(amountProducts=" + this.amountProducts + ", sum=" + this.sum + ", bucketDetails=" + this.bucketDetails + ")";
        }
    }
}
