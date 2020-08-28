package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.runSchedule.DynamicTask;
import com.example.api.runSchedule.TaskConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Resource
    DynamicTask dynamicTask;

    /**
     * 添加/更新定时任务
     */

    @RequestMapping("add")
    public WebResponse<Object> addSchedule(@RequestParam("cron") String cron, @RequestParam("taskName") String taskName) {
        ConcurrentHashMap<String, TaskConstant> taskConstants = dynamicTask.getTaskConstants();
        TaskConstant taskConstant = new TaskConstant();
        taskConstant.setCron(cron);
        taskConstant.setTaskId(taskName);
        taskConstants.put(taskName,taskConstant);
        return new WebResponse<>(ResultEnum.SUCCESS, null);
    }

    /**
     * 删除定时任务
     */
    @RequestMapping("delete")
    public WebResponse<Object> deleteSchedule(@RequestParam("taskName") String taskName) {
        ConcurrentHashMap<String, TaskConstant> taskConstants = dynamicTask.getTaskConstants();
        taskConstants.remove(taskName);
        return new WebResponse<>(ResultEnum.SUCCESS, null);
    }
}
