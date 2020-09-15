package com.example.api.controller;

import com.example.api.bean.LoginDto;
import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.UserService;
import com.example.api.tools.ImageUtil;
import com.example.dal.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class AccountController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public WebResponse<User> login(@Validated @RequestBody LoginDto loginDto) {
        User user = userService.getUserByName(loginDto.getUsername());
//        Assert.notNull(user, "用户不存在");
        if (user == null || !user.getUserName().equals(loginDto.getUsername()) || !user.getPassword().equals(loginDto.getPassword())) {
            return new WebResponse<>(ResultEnum.FAIL, null);
        }
        return new WebResponse<>(ResultEnum.SUCCESS, user);
    }
}
