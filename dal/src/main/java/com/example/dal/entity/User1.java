package com.example.dal.entity;


import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class User1 {
    Integer id;
    String userName;
    String avatar;
    String gender;
    String email;
    String newSecretOne;
    String newSecretTwo;
    Boolean isCollect;
    String description;
    Integer status;
    Date created;
    Date lastLogin;
}
