package com.example.api.controller;

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
        String res = "ok";
        if (test.size() != 0)
            res = test.get(0).getUserName() + "    " + test.get(0).getSex();
        TestDo testDo=new TestDo();
        testDo.setUserName("zhao");
        testDo.setSex("nv");
        testMapper.insert(testDo);
        log.info(res);
        return res;
    }
}
