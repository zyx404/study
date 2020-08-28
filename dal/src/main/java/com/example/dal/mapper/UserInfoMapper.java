package com.example.dal.mapper;

import com.example.dal.entity.UserInfoDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    void insertUser(@Param("userInfo") UserInfoDo userInfoDo);
}
