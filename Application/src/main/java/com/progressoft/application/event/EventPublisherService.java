package com.progressoft.application.event;

import com.progressoft.event.EventPublisher;
import com.progressoft.event.TransactionEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventPublisherService implements EventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(TransactionEvent transactionEvent) {
        applicationEventPublisher.publishEvent(new TransactionEventSpring("", transactionEvent));
    }
}
