package com.example.api.runSchedule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimingTask implements Runnable {

    private String expression;

    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(expression + " " + taskId);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
