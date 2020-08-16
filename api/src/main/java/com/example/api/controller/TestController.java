package com.example.dal.controller;

import com.example.dal.entity.TestDo;
import lombok.extern.slf4j.Slf4j;
import com.example.dal.mapper.TestMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class TestController {

    @Resource
    TestMapper testMapper;

    @RequestMapping("test")
    public String test() {
        List<TestDo> test = testMapper.getTest();
        log.info("shuai");
        return "ok";
    }
}
