package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.ImageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class ImageController {

    @Resource
    ImageService imageService;

    /**
     * 添加图片 存库
     *
     * @param image
     */
    @PostMapping("/addImage")
    public WebResponse<String> add(MultipartFile image) throws IOException {
        String res = imageService.imageFtpAndSql(image, 10);
        return new WebResponse<>(ResultEnum.SUCCESS, res);
    }

    @GetMapping("/getImage")
    public WebResponse<Object> get(@Param("ImageId") String id) {
        return null;
    }
}
