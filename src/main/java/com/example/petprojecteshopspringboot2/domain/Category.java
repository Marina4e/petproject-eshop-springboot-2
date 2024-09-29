package com.example.petprojecteshopspringboot2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    private static final String SEQ_NAME = "category_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String title;

    public Category(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category() {
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Category)) return false;
        final Category other = (Category) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        return result;
    }

    public String toString() {
        return "Category(id=" + this.getId() + ", title=" + this.getTitle() + ")";
    }

    public static class CategoryBuilder {
        private Long id;
        private String title;

        CategoryBuilder() {
        }

        public CategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Category build() {
            return new Category(this.id, this.title);
        }

        public String toString() {
            return "Category.CategoryBuilder(id=" + this.id + ", title=" + this.title + ")";
        }
    }
}
