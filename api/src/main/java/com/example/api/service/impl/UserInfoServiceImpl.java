package com.example.api.service.impl;

import com.example.api.service.UserInfoService;
import com.example.dal.entity.UserInfoDo;
import com.example.dal.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;

    /**
     * 插入用户信息表
     * @param userInfoDo 用户信息Do
     */
    @Override
    public void insertUser(UserInfoDo userInfoDo) {
        userInfoMapper.insertUser(userInfoDo);
    }
}
