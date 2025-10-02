package com.k48.managing.stock.exceptions;

public class InvalidOperationException extends RuntimeException {

    private ErrorCodes errorCode;

    // Constructor with message only
    public InvalidOperationException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with message, cause, and errorCode
    public InvalidOperationException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode; // Assign the errorCode
    }

    // Constructor with message and errorCode
    public InvalidOperationException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode; // Assign the errorCode
    }

    // Getter for errorCode
    public ErrorCodes getErrorCode() {
        return errorCode;
    }
}
