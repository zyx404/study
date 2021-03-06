package com.example.api.schedule;

import com.example.api.runSchedule.DynamicTask;
import com.example.api.runSchedule.TaskConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
public class TimeTaskTest {
    @Resource
    DynamicTask dynamicTask;

    @Test
    public void test() {
        ConcurrentHashMap<String, TaskConstant> taskConstants = dynamicTask.getTaskConstants();
        TaskConstant taskConstant = new TaskConstant();
        taskConstant.setCron("0/10 * * * * ?");
        taskConstant.setTaskId("test1");
        taskConstants.put("test1", taskConstant);

    }
}
