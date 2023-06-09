package com.progressoft.application.event;

import com.progressoft.event.TransactionEvent;
import org.springframework.context.ApplicationEvent;

public class TransactionEventSpring extends ApplicationEvent {

    private final String message;
    private final Object paylaod;
    public TransactionEventSpring(Object source, TransactionEvent transactionEvent) {
        super(source);
        this.message = transactionEvent.getMessage();
        this.paylaod = transactionEvent.getPayload();
    }

    public String getMessage() {
        return message;
    }

    public Object getPaylaod() {
        return paylaod;
    }
}
