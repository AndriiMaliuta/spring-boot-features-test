package com.anma.bh.sb.springtesting.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.println(">>> Publishing custom event. ");
        MyEvent myEvent = new MyEvent(this, message);
        applicationEventPublisher.publishEvent(myEvent);
    }
}
