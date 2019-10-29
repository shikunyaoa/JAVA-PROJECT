package com.kunyao.springboots.chapter3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Service;

/**
 * @ClassName AppConfig
 * @Description 配置文件
 * @Author kunyao
 * @Date 2019-10-29 20:07
 */
//@Configuration代表这是一个java配置文件
//Spring的容器会根据它来生成IoC容器来装配Bean
//includeFilters 定义满足过滤器（Filter)条件的Bean才去扫描
//excludeFilters 排除过滤器条件的Bean
@Configuration
@ComponentScan("com.kunyao.springboots.chapter3.*")
//ComponentScan("basePackages = {"com.springboot.chapter3.pojo"}) 通过包名定义扫描的类
//ComponentScan(basePackageClasses = {User.class}) 通过类名定义扫描的类
public class AppConfig {

    //@Bean代表initUser方法放回的POJO
    //装配到IoC容器中，而其属性name定义这个Bean的
//    @Bean(name = "user")
//    public User initUser(){
//        User user = new User();
//        user.setId(1L);
//        user.setUsername("user_name_1");
//        user.setNote("note_1");
//        return user;
//    }
}
