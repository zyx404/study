package com.example.dal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
public class HistoryDo1 {
    Integer id;
    Integer user_id;
    String image_name;
    String lr_image;
    String hr_image;
    Integer status;
    String created;
}
