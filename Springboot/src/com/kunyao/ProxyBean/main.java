package com.kunyao.ProxyBean;

import com.kunyao.ProxyBean.intercept.MyInterceptor;
import com.kunyao.ProxyBean.proxy.ProxyBean;
import com.kunyao.ProxyBean.service.HelloService;
import com.kunyao.ProxyBean.service.impl.HelloServiceImpl;

public class main {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        //按约定获取proxyBean
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("kunyao");
        System.out.println("name is null");
        proxy.sayHello(null);
    }
}
