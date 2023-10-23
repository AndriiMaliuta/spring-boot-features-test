package com.anma.bh.sb.springtesting.events;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @EventListener
    public void handleEvent1(ApplicationStartedEvent event) {
        System.out.println(">>> ApplicationStartedEvent " + event.getApplicationContext().getApplicationName());
    }
}


