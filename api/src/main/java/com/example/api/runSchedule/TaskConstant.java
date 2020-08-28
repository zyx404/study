package com.example.api.runSchedule;

import java.util.Objects;

public class TaskConstant {
    private String cron;
    private String taskId;

    public String getCron() {
        return cron;
    }
    public void setCron(String cron) {
        this.cron = cron;
    }
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

}
