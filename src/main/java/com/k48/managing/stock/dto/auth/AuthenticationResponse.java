package com.k48.managing.stock.dto.auth;

public class AuthenticationResponse {

    private String accessToken;

    // Default constructor
    public AuthenticationResponse() {
    }

    // Parameterized constructor
    public AuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getter
    public String getAccessToken() {
        return accessToken;
    }

    // Setter
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String accessToken;

        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this.accessToken);
        }
    }
}
