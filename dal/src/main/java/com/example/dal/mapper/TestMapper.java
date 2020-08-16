package com.example.api.mapper;

import com.example.api.entity.TestDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<TestDo> getTest();

}
