package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.UserInfoService;
import com.example.api.service.UserService;
import com.example.dal.entity.User;
import com.example.dal.entity.UserInfoDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Resource
    UserInfoService userInfoService;

    @Resource
    UserService userService;

    @RequestMapping("insert")
    public WebResponse<UserInfoDo> insertUser(@RequestBody UserInfoDo userInfoDo) {
        userInfoService.insertUser(userInfoDo);
        return new WebResponse<>(ResultEnum.SUCCESS, userInfoDo);
    }

    @RequestMapping("getInfo")
    public WebResponse<User> insertUser(@RequestParam("id") Long id) {
        return new WebResponse<>(ResultEnum.SUCCESS, userService.getUser(id));
    }
}
