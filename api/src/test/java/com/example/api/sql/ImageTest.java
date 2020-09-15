package com.example.api.sql;

import com.example.dal.entity.ImageDo;
import com.example.dal.mapper.ImageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ImageTest {
    @Resource
    ImageMapper imageMapper;

    @Test
    public void insertImage() {
        ImageDo imageDo = new ImageDo();
        imageDo.setUserId(10);
        imageDo.setImageName("653.jpg");
        imageDo.setLrImage("http://10.103.238.99:82/img/image/653.jpg");
        imageDo.setHrImage("http://10.103.238.99:82/img/image/653.jpg");
        imageDo.setStatus(1);
        imageMapper.insertImage(imageDo);
    }
}
