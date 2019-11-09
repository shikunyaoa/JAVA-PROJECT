package com.kunyao.springboots.chapter3.config;


import com.kunyao.springboots.chapter3.pojo.BussinessPerson;
import com.kunyao.springboots.chapter3.pojo.User;
import com.kunyao.springboots.chapter3.pojo.definition.Person;
import com.kunyao.springboots.chapter3.scope.ScopeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

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
        ScopeBean ctxBean = ctx.getBean(ScopeBean.class);
        ScopeBean ctxBean2= ctx.getBean(ScopeBean.class);
        //单例模式下，两个变量都指向同一个实例
        System.out.println(ctxBean == ctxBean2); //Singleton模式为true
        System.out.println(ctxBean == ctxBean2); //Prototype模式为false
    }
}
