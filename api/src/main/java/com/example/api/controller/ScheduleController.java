package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.runSchedule.DynamicTask;
import com.example.api.runSchedule.TaskConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Resource
    DynamicTask dynamicTask;


    @RequestMapping("add")
    public WebResponse<Object> addSchedule(@RequestParam("cron") String cron, @RequestParam("taskName") String taskName) {
        List<TaskConstant> taskConstants = dynamicTask.getTaskConstants();
        TaskConstant taskConstant = new TaskConstant();
        taskConstant.setCron(cron);
        taskConstant.setTaskId(taskName);
        taskConstants.add(taskConstant);
        return new WebResponse<>(ResultEnum.SUCCESS, null);
    }

    @RequestMapping("delete")
    public WebResponse<Object> deleteSchedule(@RequestParam("cron") String cron, @RequestParam("taskName") String taskName) {
        //重写equals和hashcode方法才可以
        List<TaskConstant> taskConstants = dynamicTask.getTaskConstants();
        TaskConstant taskConstant = new TaskConstant();
        taskConstant.setCron(cron);
        taskConstant.setTaskId(taskName);
        taskConstants.remove(taskConstant);
        return new WebResponse<>(ResultEnum.SUCCESS, null);
    }
}
