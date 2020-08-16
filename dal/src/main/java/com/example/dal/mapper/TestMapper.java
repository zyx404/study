package com.example.dal.mapper;

import com.example.dal.entity.TestDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<TestDo> getTest();

    int insert(@Param("testDo") TestDo testDo);

}
