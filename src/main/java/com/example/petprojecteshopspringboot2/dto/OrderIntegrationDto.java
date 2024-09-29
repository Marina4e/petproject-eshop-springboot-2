package com.example.petprojecteshopspringboot2.dto;

import com.example.petprojecteshopspringboot2.domain.OrderDetails;

import java.util.List;

public class OrderIntegrationDto {
    private Long orderId;
    private String username;
    private String address;
    private List<OrderDetailsDto> details;

    public OrderIntegrationDto(Long orderId, String username, String address, List<OrderDetailsDto> details) {
        this.orderId = orderId;
        this.username = username;
        this.address = address;
        this.details = details;
    }

    public OrderIntegrationDto() {
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAddress() {
        return this.address;
    }

    public List<OrderDetailsDto> getDetails() {
        return this.details;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDetails(List<OrderDetailsDto> details) {
        this.details = details;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderIntegrationDto other)) return false;
        if (!other.canEqual((Object) this)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$details = this.getDetails();
        final Object other$details = other.getDetails();
        return this$details == null ? other$details == null : this$details.equals(other$details);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderIntegrationDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $details = this.getDetails();
        result = result * PRIME + ($details == null ? 43 : $details.hashCode());
        return result;
    }

    public String toString() {
        return "OrderIntegrationDto(orderId=" + this.getOrderId() + ", username=" + this.getUsername() + ", address=" + this.getAddress() + ", details=" + this.getDetails() + ")";
    }


    public static class OrderDetailsDto {
        private String product;
        private Double price;
        private Double amount;
        private Double sum;

        public OrderDetailsDto(OrderDetails details) {
            this.product = details.getProduct().getTitle();
            this.price = details.getPrice().doubleValue();
            this.amount = details.getAmount().doubleValue();
            this.sum = details.getPrice().multiply(details.getAmount()).doubleValue();
        }

        public OrderDetailsDto(String product, Double price, Double amount, Double sum) {
            this.product = product;
            this.price = price;
            this.amount = amount;
            this.sum = sum;
        }

        public OrderDetailsDto() {
        }

        public String getProduct() {
            return this.product;
        }

        public Double getPrice() {
            return this.price;
        }

        public Double getAmount() {
            return this.amount;
        }

        public Double getSum() {
            return this.sum;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public void setSum(Double sum) {
            this.sum = sum;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof OrderDetailsDto other)) return false;
            if (!other.canEqual((Object) this)) return false;
            final Object this$product = this.getProduct();
            final Object other$product = other.getProduct();
            if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
            final Object this$price = this.getPrice();
            final Object other$price = other.getPrice();
            if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
            final Object this$amount = this.getAmount();
            final Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
            final Object this$sum = this.getSum();
            final Object other$sum = other.getSum();
            return this$sum == null ? other$sum == null : this$sum.equals(other$sum);
        }

        protected boolean canEqual(final Object other) {
            return other instanceof OrderDetailsDto;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $product = this.getProduct();
            result = result * PRIME + ($product == null ? 43 : $product.hashCode());
            final Object $price = this.getPrice();
            result = result * PRIME + ($price == null ? 43 : $price.hashCode());
            final Object $amount = this.getAmount();
            result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
            final Object $sum = this.getSum();
            result = result * PRIME + ($sum == null ? 43 : $sum.hashCode());
            return result;
        }

        public String toString() {
            return "OrderIntegrationDto.OrderDetailsDto(product=" + this.getProduct() + ", price=" + this.getPrice() + ", amount=" + this.getAmount() + ", sum=" + this.getSum() + ")";
        }
    }
}
