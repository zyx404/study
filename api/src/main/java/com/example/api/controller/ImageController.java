package com.example.api.controller;

import com.example.api.bean.History;
import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.ImageService;
import com.example.api.tensor.http.HttpClientDemo;
import com.example.dal.entity.HistoryDo;
import com.example.dal.entity.HistoryDo1;
import com.example.dal.entity.ImageDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ImageController {
    @Resource
    ImageService imageService;
    private static Integer UID = 0;

    /**
     * 添加低分辨率图片 存库
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

    /**
     * 生成高分辨率图片存库
     *
     * @param URL
     * @param userName
     * @return
     */
    @GetMapping("/getHRImage")
    public WebResponse<String> getHr(@RequestParam("url") String URL, @RequestParam("userName") String userName) {
        System.out.println(URL);
        String s = HttpClientDemo.get(URL, userName);
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

    @GetMapping("/getHistory")
    public WebResponse<List<HistoryDo1>> getHistory(@RequestParam("uid") Integer uid) {
        System.out.println();
        List<HistoryDo> l = imageService.getHistory(uid);
        List<HistoryDo1> ll = new ArrayList<>();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (HistoryDo list : l) {
            HistoryDo1 do1 = new HistoryDo1();
            do1.setId(list.getId());
            do1.setImage_name(list.getImage_name());
            do1.setLr_image(list.getLr_image());
            do1.setHr_image(list.getHr_image());
            do1.setUser_id(list.getUser_id());
            do1.setStatus(list.getStatus());
            do1.setCreated(dateFormat2.format(list.getCreated()));
            ll.add(do1);
        }
        return new WebResponse<>(ResultEnum.SUCCESS, ll);
    }
}
