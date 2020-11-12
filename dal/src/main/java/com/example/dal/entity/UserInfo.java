package com.example.dal.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfo {
    Integer id;
    String userName;
    String avatar;
    String gender;
    String email;
    String secret;
    String newSecretOne;
    String newSecretTwo;
    String description;
}
