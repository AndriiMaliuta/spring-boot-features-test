package com.anma.bh.sb.springtesting.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 60000)
    public void reportTime() {
        System.out.println(">>>  @Scheduled(fixedRate = 60000) ::: Current time is: " + LocalDateTime.now());
    }

}
