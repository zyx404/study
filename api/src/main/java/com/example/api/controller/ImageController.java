package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.ImageService;
import com.example.api.tensor.http.HttpClientDemo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class ImageController {
    @Resource
    ImageService imageService;
    private static Integer UID = 0;

    /**
     * 添加图片 存库
     *
     * @param image
     */
    @PostMapping("/addImage")
    public WebResponse<String> add(MultipartFile image, Integer uid) throws IOException {
        UID = uid;
        String res = imageService.imageFtpAndSql(image, uid);
        return new WebResponse<>(ResultEnum.SUCCESS, res);
    }

    @GetMapping("/getImage")
    public WebResponse<Object> get(@Param("ImageId") String id) {
        return null;
    }

    @GetMapping("/getHRImage")
    public WebResponse<String> getHr(@RequestParam("url") String URL) {
        System.out.println(URL);
        String s = HttpClientDemo.get(URL);
        System.out.println("高：" + s);
        imageService.imageHRToSQL(s, UID);
        return new WebResponse<>(ResultEnum.SUCCESS, s);
    }

    /**
     * 仅仅保存图片 头像
     */
    @PostMapping("/addImageOnly")
    public WebResponse<String> addImage(MultipartFile image, Integer uid) throws IOException {
        String res = imageService.imageFtp(image, uid);
        return new WebResponse<>(ResultEnum.SUCCESS, res);
    }

    @PostMapping("/addImageRegister")
    public WebResponse<String> addImageRegister(MultipartFile image) throws IOException {
        String res = imageService.imageFtpRegister(image);
        return new WebResponse<>(ResultEnum.SUCCESS, res);
    }
}
