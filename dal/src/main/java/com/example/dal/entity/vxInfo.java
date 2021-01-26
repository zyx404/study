package com.example.dal.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class vxInfo implements Serializable {
    String nickName;
    String gender;
    String language;
    String city;
    String province;
    String avatarUrl;
    String country;
}
