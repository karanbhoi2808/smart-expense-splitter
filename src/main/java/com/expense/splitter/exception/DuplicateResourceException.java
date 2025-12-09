package com.expense.splitter.exception;

public class DuplicateResourceException extends RuntimeException {
    private final static String DEFAULT_MESSAGE;

    static {
        DEFAULT_MESSAGE = "Resource already exists";
    }

    public DuplicateResourceException() {
        super(DEFAULT_MESSAGE);
    }

    public DuplicateResourceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
