package com.example.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 动态添加图片并显示
 */
@Configuration
public class ImagesUploadConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir")+"/api/src/main/resources/static/img/";
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+path);
    }
}
