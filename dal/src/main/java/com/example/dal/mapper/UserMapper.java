package com.example.dal.mapper;

import com.example.dal.entity.User;
import com.example.dal.entity.User1;
import com.example.dal.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    void insert(@Param("user") User1 User);

    User getUser(@Param("id") Long id);

    List<String> getUsers();

    User1 getUser1(@Param("id") Long id);

    User getUserByName(@Param("name") String name);

    User getUserById(@Param("id") Integer id);

    void userEdit(@Param("userInfo") UserInfo userInfo);

    void userEditNoSecret(@Param("userInfo") UserInfo userInfo);

}
