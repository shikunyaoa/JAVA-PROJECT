package com.kunyao.springboots.chapter4.service.impl;

import com.kunyao.springboots.chapter4.service.HelloService;

/**
 * @ClassName HelloServiceImpl
 * @Description 简单接口
 * @Author kunyao
 * @Date $
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(name == null || name.trim() == ""){
            throw new RuntimeException("parameter is null");
        }
        System.out.println("hello " + name);
    }
}
