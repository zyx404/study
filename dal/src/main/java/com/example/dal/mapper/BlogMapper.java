package com.example.dal.mapper;

import com.example.dal.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMapper {
    void insert(@Param("blog")Blog blog);
}
