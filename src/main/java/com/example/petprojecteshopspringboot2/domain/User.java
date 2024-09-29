package com.example.petprojecteshopspringboot2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String password;
    private String email;
    private boolean archive;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Bucket bucket;
    @Column(name = "activate_code", length = 80)
    private String activeCode;

    public String getActivateCode() {
        return activeCode;
    }

    public void setActivateCode(String activateCode) {
        this.activeCode = activateCode;
    }

    public User(Long id, String name, String password, String email,
                boolean archive, Role role, Bucket bucket, String activeCode) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.archive = archive;
        this.role = role;
        this.bucket = bucket;
        this.activeCode = activeCode;
    }

    public User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isArchive() {
        return this.archive;
    }

    public Role getRole() {
        return this.role;
    }

    public Bucket getBucket() {
        return this.bucket;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        if (this.isArchive() != other.isArchive()) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$bucket = this.getBucket();
        final Object other$bucket = other.getBucket();
        if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        result = result * PRIME + (this.isArchive() ? 79 : 97);
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $bucket = this.getBucket();
        result = result * PRIME + ($bucket == null ? 43 : $bucket.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() +
                ", password=" + this.getPassword() + ", email=" + this.getEmail()
                + ", archive=" + this.isArchive() + ", role=" + this.getRole()
                + ", bucket=" + this.getBucket() + ")";
    }

    public static class UserBuilder {
        private Long id;
        private String name;
        private String password;
        private String email;
        private boolean archive;
        private Role role;
        private Bucket bucket;
        private String activeCode;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder archive(boolean archive) {
            this.archive = archive;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserBuilder bucket(Bucket bucket) {
            this.bucket = bucket;
            return this;
        }

        public UserBuilder activeCode(String activateCode) {
            this.activeCode = activateCode;
            return this;
        }

        public User build() {
            return new User(this.id, this.name, this.password, this.email,
                    this.archive, this.role, this.bucket, this.activeCode);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", name=" + this.name +
                    ", password=" + this.password + ", email=" + this.email +
                    ", archive=" + this.archive + ", role=" + this.role +
                    ", bucket=" + this.bucket + ", activateCode=" +
                    this.activeCode + ")";
        }


    }
}
