package com.progressoft.exception;

public class NotEnoughBalanceException extends RuntimeException{
    public NotEnoughBalanceException() {
        super("Not Enough Balance");
    }

    public NotEnoughBalanceException(String message) {
        super(message);
    }
}
