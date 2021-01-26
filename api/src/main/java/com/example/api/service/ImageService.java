package com.example.api.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String imageFtpAndSql(MultipartFile file, Integer userId) throws IOException;

    String imageFtp(MultipartFile file, Integer userId) throws IOException;

    String imageFtpRegister(MultipartFile file) throws IOException;

    void imageHRToSQL(String fileName, Integer userId);
}
