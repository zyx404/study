package com.example.dal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryDo {
    Integer id;
    Integer user_id;
    String image_name;
    String lr_image;
    String hr_image;
    Integer status;
    Date created;
}
