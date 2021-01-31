package com.example.api.service.impl;

import com.example.api.constants.FtpParam;
import com.example.api.service.ImageService;
import com.example.api.tools.FtpUtil;
import com.example.dal.entity.HistoryDo;
import com.example.dal.entity.ImageDo;
import com.example.dal.entity.User;
import com.example.dal.mapper.ImageMapper;
import com.example.dal.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Resource
    ImageMapper imageMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public String imageFtpAndSql(MultipartFile file, Integer userId) throws IOException {
        //TODO: 2020/9/4 图片名校验
        String fileName = file.getOriginalFilename();
        //根据userId 获取用户名
        User user = userMapper.getUser((long) userId);
        //根据不同的用户定义不同的文件夹
        String ImageName = user.getUserName() + "/";

        imageMapper.insertImage(buildImageDo(fileName, userId, ImageName));
        FtpUtil.uploadFile(FtpParam.host, FtpParam.port, FtpParam.username, FtpParam.passwd, FtpParam.basePath, ImageName, fileName, file.getInputStream());
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
        FtpUtil.uploadFile(FtpParam.host, FtpParam.port, FtpParam.username, FtpParam.passwd, FtpParam.basePath, FtpParam.filePath + "avatar", fileName, file.getInputStream());
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
    public void imageHRToSQL(String fileName, Integer userId) {
        String name = fileName.split("-")[0];
        String tabel = fileName.split("\\.")[1];
        String lrName = fileName.split("-")[0] + '.' + tabel;
        String lrNameIp = imageMapper.getImage(lrName, userId);

        //根据userId 获取用户名
        User user = userMapper.getUser((long) userId);
        //根据不同的用户定义不同的文件夹
        String ImageName = user.getUserName() + "/";

        if (lrNameIp != null) {
            String url = "http://" + FtpParam.host + ":" + FtpParam.nginx_port + "/img" + FtpParam.filePath + ImageName + fileName;
            imageMapper.updateImage(lrNameIp, userId, url);
        }
    }

    @Override
    public List<HistoryDo> getHistory(Integer uid) {
        return imageMapper.getHistory(uid);
    }


    private ImageDo buildImageDo(String fileName, Integer userId, String ImageName) {
        // http://10.103.238.99:82/img/image/653.jpg
        ImageDo imageDo = new ImageDo();
        String url = "http://" + FtpParam.host + ":" + FtpParam.nginx_port + "/img" + FtpParam.filePath + ImageName + fileName;
        imageDo.setImageName(fileName);
        imageDo.setUserId(userId);
        imageDo.setLrImage(url);
        imageDo.setHrImage("no have");
        imageDo.setStatus(1);
        return imageDo;
    }
}
