package com.example.api.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    @Scheduled(cron = "0/10 * * * * ?")
    public void scheduleCron() {
        System.out.println("运行");
    }
}
