package com.example.dal.mapper;

import com.example.dal.entity.User;
import com.example.dal.entity.User1;
import com.example.dal.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void insert(@Param("user") User1 User);

    User getUser(@Param("id") Long id);

    User getUserByName(@Param("name") String name);

    void userEdit(@Param("userInfo") UserInfo userInfo);

    void userEditNoSecret(@Param("userInfo") UserInfo userInfo);
}
