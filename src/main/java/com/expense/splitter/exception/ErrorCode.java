package com.expense.splitter.exception;


import lombok.Getter;

public enum ErrorCode {
    EMAIL_ALREADY_EXISTS("Email already exists."),
    USER_NOT_FOUND("User not found."),
    GROUP_NOT_FOUND("Group not found.");

    @Getter
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
