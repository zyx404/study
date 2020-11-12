package com.example.api.service.impl;

import com.example.api.constants.FtpParam;
import com.example.api.service.ImageService;
import com.example.api.tools.FtpUtil;
import com.example.dal.entity.ImageDo;
import com.example.dal.mapper.ImageMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Resource
    ImageMapper imageMapper;

    @Override
    public String imageFtpAndSql(MultipartFile file, Integer userId) throws IOException {
        //TODO: 2020/9/4 图片名校验
        String fileName = file.getOriginalFilename();
        imageMapper.insertImage(buildImageDo(fileName, userId));
        FtpUtil.uploadFile(FtpParam.host, FtpParam.port, FtpParam.username, FtpParam.passwd, FtpParam.basePath, FtpParam.filePath, fileName, file.getInputStream());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @Override
    public String imageFtp(MultipartFile file, Integer userId) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        FtpUtil.uploadFile(FtpParam.host, FtpParam.port, FtpParam.username, FtpParam.passwd, FtpParam.basePath, FtpParam.filePath+"avatar", fileName, file.getInputStream());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @Override
    public String imageFtpRegister(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        FtpUtil.uploadFile(FtpParam.host, FtpParam.port, FtpParam.username, FtpParam.passwd, FtpParam.basePath, FtpParam.filePath + "avatar", fileName, file.getInputStream());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @Override
    public String imageHRToSQL(String fileName, Integer userId) {
        imageMapper.insertImage(buildImageDo(fileName, userId));
        return "SUCCESS";
    }


    private ImageDo buildImageDo(String fileName, Integer userId) {
        // http://10.103.238.99:82/img/image/653.jpg
        ImageDo imageDo = new ImageDo();
        String url = "http://" + FtpParam.host + ":" + FtpParam.nginx_port + "/img" + FtpParam.filePath + "/" + fileName;
        imageDo.setImageName(fileName);
        imageDo.setUserId(userId);
        imageDo.setLrImage(url);
        imageDo.setHrImage(url);
        imageDo.setStatus(1);
        return imageDo;
    }
}
