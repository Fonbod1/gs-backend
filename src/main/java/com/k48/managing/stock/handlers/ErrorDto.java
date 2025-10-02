package com.k48.managing.stock.handlers;

import com.k48.managing.stock.exceptions.ErrorCodes;
import java.util.ArrayList;
import java.util.List;

public class ErrorDto {

    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    private List<String> errors = new ArrayList<>();

    // Private constructor to enforce Builder pattern
    private ErrorDto(Builder builder) {
        this.httpCode = builder.httpCode;
        this.code = builder.code;
        this.message = builder.message;
        this.errors = builder.errors;
    }

    // Getters
    public Integer getHttpCode() {
        return httpCode;
    }

    public ErrorCodes getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    // Builder class
    public static class Builder {
        private Integer httpCode;
        private ErrorCodes code;
        private String message;
        private List<String> errors = new ArrayList<>();

        public Builder httpCode(Integer httpCode) {
            this.httpCode = httpCode;
            return this;
        }

        public Builder code(ErrorCodes code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder errors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        // Build method to create the ErrorDto instance
        public ErrorDto build() {
            return new ErrorDto(this);
        }
    }
}
