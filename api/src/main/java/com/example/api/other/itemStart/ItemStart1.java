package com.example.api.other.itemStart;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 在bean中加入@PostConstruct
 * 注：要标注Bean
 */

//@Service
public class ItemStart1 {
    //项目启动时就会运行
    @PostConstruct
    public void init(){
        System.out.println("你可真帅");
    }
}
