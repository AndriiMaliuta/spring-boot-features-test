package com.anma.bh.sb.springtesting.scheduled;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Log
public class ScheduledTask {

    @Scheduled(fixedRate = 60000)
    public void reportTime() {
        log.info("Current time is: " + LocalDateTime.now());
    }

}
