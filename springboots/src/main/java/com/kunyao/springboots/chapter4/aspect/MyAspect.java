package com.kunyao.springboots.chapter4.aspect;

import com.kunyao.springboots.chapter4.aspect.validator.UserValudator;
import com.kunyao.springboots.chapter4.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.annotation.*;

/**
 * @ClassName MyAspect
 * @Description 自定义切面
 * @Author kunyao
 * @Date $
 */
//@Aspect作为切面声明的
@Aspect
public class MyAspect {

    //@DeclareParents 表示引入新的类来增强服务
    //value 指向要增强功能的目标对象
    //defaultImpl 引入增强功能的类
    @DeclareParents(value = "com.kunyao.springboots.chapter4.aspect.service.impl.UserServiceImpl+", defaultImpl = UserValidatorImpl.class)
    public UserValudator userValudator;
    //execution表示在执行的时候，拦截里面的正则匹配的方法
    // * 表示任意返回类型的方法
    //(..) 表示任意参数进行匹配
    @Pointcut("execution(* com.kunyao.springboots.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }


    @Before("pointCut()")
    public void before() {
        System.out.println("before ......");
    }
    @After("pointCut()")
    public void after(){
        System.out.println("after ......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing ......");
    }
}
