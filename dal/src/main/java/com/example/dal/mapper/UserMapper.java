package com.example.dal.mapper;

import com.example.dal.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void insert(@Param("user") User User);

    User getUser(@Param("id") Long id);

    User getUserByName(@Param("name") String name);
}
