package com.k48.managing.stock.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private ErrorCodes errorCode;

    // Constructor with message only
    public EntityNotFoundException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with message and errorCode
    public EntityNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;  // Set the error code
    }

    // Constructor with message, cause, and errorCode
    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;  // Set the error code
    }

    // Getter for errorCode
    public ErrorCodes getErrorCode() {
        return errorCode;
    }
}
