package com.example.dal.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    Integer id;
    String userName;
    String avatar;
    String email;
    String password;
    Integer status;
    Date created;
    Date lastLogin;
}
