package com.example.dal.mapper;

import com.example.dal.entity.HistoryDo;
import com.example.dal.entity.ImageDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {
    void insertImage(@Param("imageDo") ImageDo imageDo);

    String getImage(@Param("imageName") String imageName, @Param("userId") Integer userId);

    String getLrImage(@Param("imageName") String name);

    void updateImage(@Param("imageName") String imageName, @Param("userId") Integer userId, @Param("imageHrImage") String imageHrImage);

    List<HistoryDo> getHistory(@Param("uid") Integer uid);
}
