package com.example.petprojecteshopspringboot2.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "buckets")
public class Bucket {
    private static final String SEQ_NAME = "bucket_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name = "buckets_products",
            joinColumns = @JoinColumn(name = "bucket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Bucket(Long id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public Bucket() {
    }

    public static BucketBuilder builder() {
        return new BucketBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Bucket)) return false;
        final Bucket other = (Bucket) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$products = this.getProducts();
        final Object other$products = other.getProducts();
        if (this$products == null ? other$products != null : !this$products.equals(other$products)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Bucket;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $products = this.getProducts();
        result = result * PRIME + ($products == null ? 43 : $products.hashCode());
        return result;
    }

    public String toString() {
        return "Bucket(id=" + this.getId() + ", user=" + this.getUser() + ", products=" + this.getProducts() + ")";
    }

    public static class BucketBuilder {
        private Long id;
        private User user;
        private List<Product> products;

        BucketBuilder() {
        }

        public BucketBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BucketBuilder user(User user) {
            this.user = user;
            return this;
        }

        public BucketBuilder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public Bucket build() {
            return new Bucket(this.id, this.user, this.products);
        }

        public String toString() {
            return "Bucket.BucketBuilder(id=" + this.id + ", user=" + this.user + ", products=" + this.products + ")";
        }
    }
}
