package com.example.api.sql;

import com.example.dal.entity.Blog;
import com.example.dal.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BlogTest {
    @Resource
    BlogMapper blogMapper;

    @Test
    public void blogInsertTest() {
        Blog blog = Blog.builder()
                .userId(10)
                .title("小何")
                .description("科技")
                .content("你好帅")
                .status(1)
                .build();
        blogMapper.insert(blog);
    }
}
