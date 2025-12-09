package com.expense.splitter.exception;

public class ResourceNotFoundException extends RuntimeException {
    private final static String DEFAULT_MESSAGE;

    static {
        DEFAULT_MESSAGE = "Resource not found";
    }

    public ResourceNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ResourceNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
