package com.progressoft.application.event;

import com.progressoft.event.EventPublisher;
import com.progressoft.event.TransactionEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class EventPublisherService implements EventPublisher {

    @Override
    public void publish(TransactionEvent transactionEvent) {

    }
}
