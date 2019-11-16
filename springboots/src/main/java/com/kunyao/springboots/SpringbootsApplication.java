package com.kunyao.springboots;

import com.kunyao.springboots.chapter4.aspect.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@MapperScan(basePackages = "com.kunyao.springboots.chapter6",
    annotationClass = Repository.class)
@SpringBootApplication(
        scanBasePackages = {"com.kunyao.springboots.chapter6"})
public class SpringbootsApplication {

    //注入事务管理器，它由Spring Boot自动生成
    @Autowired
    PlatformTransactionManager transactionManager = null;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootsApplication.class, args);
    }

}
