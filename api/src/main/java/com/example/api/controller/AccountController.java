package com.example.api.controller;

import com.example.api.bean.LoginDto;
import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.UserService;
import com.example.api.tools.ImageUtil;
import com.example.dal.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

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

    /**
     * 添加图片 存库
     *
     * @param image
     */
    @PostMapping("/add")
    public WebResponse<Object> add(MultipartFile image) throws IOException {
        // TODO: 2020/9/4 图片名校验
        String x = image.getOriginalFilename();
        File imageFolder = new File("/Users/zuoyuanxun/Java/image");
        File file = new File(imageFolder, x);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return new WebResponse<>(ResultEnum.SUCCESS, null);
    }
}
