package com.kunyao.springboots.chapter3.config;


import com.kunyao.springboots.chapter3.pojo.BussinessPerson;
import com.kunyao.springboots.chapter3.pojo.User;
import com.kunyao.springboots.chapter3.pojo.definition.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName IoCTest
 * @Description 使用AnnotationConfigApplicationContext来构建IoC容器
 * @Author kunyao
 * @Date
 */
public class IoCTest {

    private static Logger logger = LoggerFactory.getLogger(IoCTest.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ctx.getBean(BussinessPerson.class);
        person.service();
    }
}
