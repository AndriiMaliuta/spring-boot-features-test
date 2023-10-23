package com.anma.bh.sb.springtesting.events;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @EventListener
    public void handleStartEvent(ApplicationStartedEvent event) {
        System.out.println(">>> ApplicationStartedEvent " + event.getApplicationContext().getApplicationName());
    }

    @EventListener
    public void ready(ApplicationReadyEvent event) {
        var startSecs = event.getTimeTaken().getSeconds();
        System.out.printf(">> ApplicationReadyEvent :: took %d sec", startSecs);
    }

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        switch (event.getState()) {
            case ACCEPTING_TRAFFIC:
                // create file /tmp/healthy
                break;
            case REFUSING_TRAFFIC:
                // remove file /tmp/healthy
                break;
        }
    }

    @EventListener
    public void onCtxCHange(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
    }


}


