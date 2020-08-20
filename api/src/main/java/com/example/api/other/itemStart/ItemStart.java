package com.example.api.other.itemStart;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 实现InitializingBean接口并重写afterPropertiesSet方法
 * 注：要标注Bean
 */

//@Service
public class ItemStart implements InitializingBean {
    //项目启动时就会运行
    public void init(){
        System.out.println("你可真帅");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("你可真帅");
    }
}
