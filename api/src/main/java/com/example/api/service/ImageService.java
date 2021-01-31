package com.example.api.service;

import com.example.dal.entity.HistoryDo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    String imageFtpAndSql(MultipartFile file, Integer userId) throws IOException;

    String imageFtp(MultipartFile file, Integer userId) throws IOException;

    String imageFtpRegister(MultipartFile file) throws IOException;

    void imageHRToSQL(String fileName, Integer userId);

    List<HistoryDo> getHistory(Integer uid);
}
