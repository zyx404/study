package com.example.api.service;

import com.example.dal.entity.HistoryDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    String imageFtpAndSql(MultipartFile file, Integer userId) throws IOException;

    List<String> imageName(Integer uid);

    String lrImage(String fileName,Integer uid);

    String imageFtp(MultipartFile file, Integer userId) throws IOException;

    String imageFtpRegister(MultipartFile file) throws IOException;

    String imageHRToSQL(String fileName, Integer userId);

    /**
     * 看是否回复过
     */
    String hrImage(String imageName,String userName);

    List<HistoryDo> getHistory(Integer uid);
}
