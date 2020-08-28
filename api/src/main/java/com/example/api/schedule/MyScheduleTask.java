package com.example.api.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

//@Configuration
public class MyScheduleTask implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> System.out.println("帅"), triggerContext -> {
            CronTrigger trigger=new CronTrigger("0/10 * * * * ?");
            return trigger.nextExecutionTime(triggerContext);
        });
    }
}
