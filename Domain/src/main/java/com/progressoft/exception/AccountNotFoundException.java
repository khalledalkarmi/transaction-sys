package com.progressoft.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
        super("Account Not Found");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
