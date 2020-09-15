package com.example.dal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ImageDo {
    Integer id;
    Integer userId;
    String imageName;
    String lrImage;
    String hrImage;
    Integer status;
    Date created;

}
