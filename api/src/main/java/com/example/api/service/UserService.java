package com.example.api.service;

import com.example.dal.entity.User;

public interface UserService {

    User getUser(Long id);
    User getUserByName(String name);
}
