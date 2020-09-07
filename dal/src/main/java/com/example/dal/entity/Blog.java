package com.example.dal.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Blog {
    Integer id;
    Integer userId;
    String title;
    String description;
    String content;
    Date created;
    Integer status;
}
