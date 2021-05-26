package com.example.api.service;

import com.example.dal.entity.User;
import com.example.dal.entity.User1;
import com.example.dal.entity.UserInfo;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    User getUserByName(String name);

    User getUserById(Integer id);

    void userEdit(UserInfo userInfo);

    void userEditNoSecret(UserInfo userInfo);

    void userRegister(User1 user);

    List<String> getUser();
}
