package com.example.api.sql;

import com.example.dal.entity.User;
import com.example.dal.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserTest {
    @Resource
    UserMapper userMapper;

    @Test
    public void userInsertTest() {
        User user = new User();
        user.setUserName("yuan");
        user.setAvatar("2");
        user.setEmail("15754301578@163.com");
        user.setPassword("qwaas");
        user.setStatus(1);
        userMapper.insert(user);

    }

    @Test
    public void getUser() {
        User user = userMapper.getUser(1L);
        System.out.println();
    }

}
