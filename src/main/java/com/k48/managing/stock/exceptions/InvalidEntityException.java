package com.k48.managing.stock.exceptions;

import java.util.List;

public class InvalidEntityException extends RuntimeException {

    private ErrorCodes errorCode;
    private List<String> errors;

    // Constructor with message only
    public InvalidEntityException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with message and errorCode
    public InvalidEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Constructor with message, cause, and errorCode
    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    // Constructor with message, errorCode, and errors list
    public InvalidEntityException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    // Getter for errorCode
    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    // Getter for errors list
    public List<String> getErrors() {
        return errors;
    }
}
