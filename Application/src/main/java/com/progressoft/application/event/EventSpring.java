package com.progressoft.application.event;

import org.springframework.context.ApplicationEvent;

public class EventSpring extends ApplicationEvent {
    public EventSpring(Object source) {
        super(source);
    }
}
