package com.example.api.runSchedule;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.util.CollectionUtils;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.*;

@Configuration
@Slf4j
public class DynamicTask implements SchedulingConfigurer {


    private volatile ScheduledTaskRegistrar registrar;
    private final ConcurrentHashMap<String, ScheduledFuture<?>> scheduledFutures = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CronTask> cronTasks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, TaskConstant> taskConstants = new ConcurrentHashMap<>();

    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {
        this.registrar = registrar;
        this.registrar.addTriggerTask(() -> {
                    if (!CollectionUtils.isEmpty(taskConstants)) {
                        log.info("检测动态定时任务列表...");
                        List<TimingTask> tts = new ArrayList<>();
                        taskConstants.values().forEach(taskConstant -> {
                                    TimingTask tt = new TimingTask();
                                    tt.setExpression(taskConstant.getCron());
                                    tt.setTaskId("dynamic-task-" + taskConstant.getTaskId());
                                    tts.add(tt);
                                }
                        );
                        this.refreshTasks(tts);
                    }
                }
                , triggerContext -> new PeriodicTrigger(5L, TimeUnit.SECONDS).nextExecutionTime(triggerContext));
    }


    public ConcurrentHashMap<String, TaskConstant> getTaskConstants() {
        return taskConstants;
    }

    private void refreshTasks(List<TimingTask> tasks) {
        //取消已经删除的策略任务
        Set<String> taskIds = scheduledFutures.keySet();
        for (String taskId : taskIds) {
            if (!exists(tasks, taskId)) {
                scheduledFutures.get(taskId).cancel(false);
            }
        }
        for (TimingTask tt : tasks) {
            String expression = tt.getExpression();
            if (StringUtils.isBlank(expression) || !CronSequenceGenerator.isValidExpression(expression)) {
                log.error("定时任务DynamicTask cron表达式不合法: " + expression);
                continue;
            }
            //如果配置一致，则不需要重新创建定时任务
            if (scheduledFutures.containsKey(tt.getTaskId())
                    && cronTasks.get(tt.getTaskId()).getExpression().equals(expression)) {
                continue;
            }
            //如果策略执行时间发生了变化，则取消当前策略的任务
            if (scheduledFutures.containsKey(tt.getTaskId())) {
                scheduledFutures.remove(tt.getTaskId()).cancel(false);
                cronTasks.remove(tt.getTaskId());
            }
            CronTask task = new CronTask(tt, expression);
            ScheduledFuture<?> future = Objects.requireNonNull(registrar.getScheduler()).schedule(task.getRunnable(), task.getTrigger());
            cronTasks.put(tt.getTaskId(), task);
            scheduledFutures.put(tt.getTaskId(), future);
        }
    }

    private boolean exists(List<TimingTask> tasks, String taskId) {
        for (TimingTask task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return true;
            }
        }
        return false;
    }

    @PreDestroy
    public void destroy() {
        this.registrar.destroy();
    }
}
