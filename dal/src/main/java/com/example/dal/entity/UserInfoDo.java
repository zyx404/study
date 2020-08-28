package com.example.dal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDo {

    Integer id;

    String name;

    Integer sex;

    Integer age;

    String job;

    Integer phone;

    String other;

    Date date;
}
