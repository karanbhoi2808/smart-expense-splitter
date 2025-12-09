package com.expense.splitter.exception;

public class EmailAlreadyExists extends DuplicateResourceException {
    public EmailAlreadyExists() {
        super(ErrorCode.EMAIL_ALREADY_EXISTS);
    }
}
