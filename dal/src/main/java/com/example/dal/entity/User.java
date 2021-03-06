package com.example.dal.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    Integer id;
    String userName;
    String avatar;
    String gender;
    String email;
    String password;
    Boolean isCollect;
    String description;
    Integer status;
    Date created;
    Date lastLogin;
}
