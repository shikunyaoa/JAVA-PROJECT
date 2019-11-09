package com.kunyao.springboots.chapter4.intercept;

import com.kunyao.springboots.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName MyInterceptor
 * @Description 自定义拦截器
 * @Author kunyao
 * @Date $
 */
public class MyInterceptor implements Interceptor{
    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ......");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before");
        Object obj = invocation.proceed();
        System.out.println("around after");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing .......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
