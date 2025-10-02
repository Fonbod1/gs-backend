package com.k48.managing.stock.dto.auth;

public class AuthenticationRequest {

    private String login;
    private String password;

    // Default constructor
    public AuthenticationRequest() {
    }

    // Parameterized constructor
    public AuthenticationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Getter for login
    public String getLogin() {
        return login;
    }

    // Setter for login
    public void setLogin(String login) {
        this.login = login;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Manual builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String login;
        private String password;

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public AuthenticationRequest build() {
            return new AuthenticationRequest(this.login, this.password);
        }
    }
}
