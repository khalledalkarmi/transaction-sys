package com.progressoft.application.event;

import com.progressoft.event.EventPublisher;
import com.progressoft.event.TransactionEvent;
import org.springframework.context.ApplicationEventPublisher;

public class EventPublisherService implements EventPublisher {

    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(TransactionEvent transactionEvent) {
        applicationEventPublisher.publishEvent(new EventSpring("", transactionEvent));
    }
}
