package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.UserService;
import com.example.dal.entity.UserInfoDo;
import com.example.dal.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("insert")
    public WebResponse<UserInfoDo> insertUser(@RequestBody UserInfoDo userInfoDo) {
        userService.insertUser(userInfoDo);
        return new WebResponse<>(ResultEnum.SUCCESS, userInfoDo);
    }
}
