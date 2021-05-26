package com.example.api.service.impl;

import com.example.api.service.UserService;
import com.example.dal.entity.User;
import com.example.dal.entity.User1;
import com.example.dal.entity.UserInfo;
import com.example.dal.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void userEdit(UserInfo userInfo) {
        userMapper.userEdit(userInfo);
    }

    @Override
    public void userEditNoSecret(UserInfo userInfo) {
        userMapper.userEditNoSecret(userInfo);
    }

    @Override
    public void userRegister(User1 user) {
        userMapper.insert(user);
    }

    @Override
    public List<String> getUser() {
        return userMapper.getUsers();
    }
}
