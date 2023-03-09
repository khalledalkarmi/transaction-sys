package com.progressoft.exception;

public class InvalidTransactionException extends RuntimeException{
    public InvalidTransactionException() {
        super();
    }

    public InvalidTransactionException(String message) {
        super(message);
    }
}
