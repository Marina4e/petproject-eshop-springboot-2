package com.example.petprojecteshopspringboot2.dto;


public class UserDTO {
    private String username;
    private String password;
    private String matchingPassword;
    private String email;
    private boolean activated;

    public UserDTO(String username, String password, String matchingPassword, String email, boolean activated) {
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
        this.activated = activated;
    }

    public UserDTO() {
    }

    public static UserDTOBuilder builder() {
        return new UserDTOBuilder();
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getMatchingPassword() {
        return this.matchingPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDTO)) return false;
        final UserDTO other = (UserDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$matchingPassword = this.getMatchingPassword();
        final Object other$matchingPassword = other.getMatchingPassword();
        if (this$matchingPassword == null ? other$matchingPassword != null : !this$matchingPassword.equals(other$matchingPassword))
            return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $matchingPassword = this.getMatchingPassword();
        result = result * PRIME + ($matchingPassword == null ? 43 : $matchingPassword.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO(username=" + username + ", password=" + password + ", matchingPassword=" + matchingPassword +
                ", email=" + email + ", activated=" + activated + ")";
    }

    public static class UserDTOBuilder {
        private String username;
        private String password;
        private String matchingPassword;
        private String email;
        private boolean activated;

        UserDTOBuilder() {
        }

        public UserDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDTOBuilder matchingPassword(String matchingPassword) {
            this.matchingPassword = matchingPassword;
            return this;
        }

        public UserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder activated(boolean activated) {
            this.activated = activated;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this.username, this.password, this.matchingPassword, this.email, this.activated);
        }

        @Override
        public String toString() {
            return "UserDTO.UserDTOBuilder(username=" + username + ", password=" + password +
                    ", matchingPassword=" + matchingPassword + ", email=" + email +
                    ", activated=" + activated + ")";
        }
    }
}