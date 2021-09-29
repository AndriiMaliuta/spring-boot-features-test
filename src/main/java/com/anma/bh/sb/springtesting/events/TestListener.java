package com.anma.bh.sb.springtesting.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestListener {

    @EventListener
    public void handleEvent1(ApplicationStartedEvent event) {
      log.info(">>> ApplicationStartedEvent " + event.getApplicationContext().getApplicationName());
    }
}


