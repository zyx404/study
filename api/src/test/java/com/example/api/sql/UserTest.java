package com.example.api.sql;

import com.example.dal.entity.User;
import com.example.dal.entity.User1;
import com.example.dal.entity.UserInfo;
import com.example.dal.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserTest {
    @Resource
    UserMapper userMapper;

    /**
     * 插入用户测试
     */
    @Test
    public void userInsertTest() {
        User1 user = new User1();
        user.setUserName("yuan");
        user.setAvatar("2");
        user.setGender("男");
        user.setEmail("15754301578@163.com");
        user.setNewSecretOne("qwaas");
        user.setDescription("你猜我猜不猜你猜不猜");
        user.setStatus(1);
        userMapper.insert(user);

    }

    @Test
    public void getUser() {
        User user = userMapper.getUser(3L);
        System.out.println();
    }

    @Test
    public void updateUserInfoTest(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(3);
        userInfo.setUserName("yuan");
        userInfo.setAvatar("2");
        userInfo.setGender("女");
        userInfo.setEmail("15754301578@163.com");
        userInfo.setNewSecretOne("asa");
        userInfo.setDescription("你猜我猜不猜你猜不猜");
        userMapper.userEdit(userInfo);
    }

}
