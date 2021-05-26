package com.example.api.controller;

import com.example.api.bean.LoginDto;
import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.UserService;
import com.example.api.tools.ImageUtil;
import com.example.dal.entity.User;
import com.example.dal.entity.User1;
import com.example.dal.entity.User2;
import com.example.dal.entity.UserInfo;
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
import java.util.List;

@RestController
public class AccountController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public WebResponse<User> login(@Validated @RequestBody LoginDto loginDto) {
        System.out.println(loginDto.getUsername());
        System.out.println(loginDto.getPassword());
        User user = userService.getUserByName(loginDto.getUsername());
//        Assert.notNull(user, "用户不存在");
        if (user == null || !user.getUserName().equals(loginDto.getUsername()) || !user.getPassword().equals(loginDto.getPassword())) {
            return new WebResponse<>(ResultEnum.FAIL0, null);
        }
        return new WebResponse<>(ResultEnum.SUCCESS, user);
    }

    @PostMapping("/register")
    public WebResponse<User1> register(@Validated @RequestBody User1 user) {
        if (user.getUserName() == null || user.getNewSecretTwo() == null || user.getNewSecretOne() == null || user.getAvatar() == null || user.getDescription() == null ||
                user.getGender() == null || user.getEmail() == null)
            return new WebResponse<>(ResultEnum.PARA_IS_NULL, null);
        if (!user.getNewSecretOne().equals(user.getNewSecretTwo()))
            return new WebResponse<>(ResultEnum.SECRET_IS_DIFF, null);
        List<String> userName = userService.getUser();
        if (userName.contains(user.getUserName()))
            return new WebResponse<>(ResultEnum.FAIL1, null);
        userService.userRegister(user);
        return new WebResponse<>(ResultEnum.SUCCESS, user);
    }

    @PostMapping("/userEdit")
    public WebResponse<Object> userEdit(@Validated @RequestBody UserInfo userInfo) {
        User user = userService.getUserById(userInfo.getId());
        if (!user.getPassword().equals(userInfo.getSecret()))
            return new WebResponse<>(ResultEnum.PASSWD_NULL_OR_DIFF, null);
        if (!userInfo.getNewSecretOne().equals(userInfo.getNewSecretTwo()))
            return new WebResponse<>(ResultEnum.SECRET_IS_DIFF, null);
        if (userInfo.getSecret() == null || userInfo.getSecret().equals("")) {
            userService.userEditNoSecret(userInfo);
            return new WebResponse<>(ResultEnum.SUCCESS, null);
        }
        //用户名不一致，则修改用户名
        if (!userInfo.getUserName().equals(user.getUserName())){
            List<String> userName = userService.getUser();
            if (userName.contains(userInfo.getUserName()))
                return new WebResponse<>(ResultEnum.FAIL1, null);
        }
        if (userInfo.getNewSecretOne() == null || userInfo.getNewSecretOne().equals("")) {
            userService.userEditNoSecret(userInfo);
            return new WebResponse<>(ResultEnum.SUCCESS, null);
        }
        userService.userEdit(userInfo);
        return new WebResponse<>(ResultEnum.SUCCESS, null);
    }
}
