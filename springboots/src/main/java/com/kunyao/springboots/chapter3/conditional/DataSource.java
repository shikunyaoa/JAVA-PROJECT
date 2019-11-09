package com.kunyao.springboots.chapter3.conditional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName DataSource
 * @Description 使用@Conditional注解进行条件装配Bean
 * @Author kunyao
 * @Date $
 */
@Component
public class DataSource {

    @Bean(name = "dataSource")
    //配置了DatabaseConditional，这个类必须实现Condition接口
    //当满足条件时Spring会装配数据库池的Bean,否则不装配
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource(
            @Value("${database.driverName}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password
    ){
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;

        try {
           // dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}
