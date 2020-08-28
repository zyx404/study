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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskConstant that = (TaskConstant) o;
        return Objects.equals(cron, that.cron) &&
                Objects.equals(taskId, that.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cron, taskId);
    }
}
