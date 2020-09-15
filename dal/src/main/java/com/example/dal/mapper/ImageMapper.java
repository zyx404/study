package com.example.dal.mapper;

import com.example.dal.entity.ImageDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMapper {
    void insertImage(@Param("imageDo") ImageDo imageDo);
    String getLrImage(@Param("imageName") String name);
}
