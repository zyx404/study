package com.example.api.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String imageFtpAndSql(MultipartFile file,Integer userId) throws IOException;
}
