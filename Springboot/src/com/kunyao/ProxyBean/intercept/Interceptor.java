package com.kunyao.ProxyBean.intercept;

import com.kunyao.ProxyBean.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    public boolean before();


    public boolean after();

    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    public void afterReturning();

    public void afterThrowing();

    //是否使用around取代原有的方法
    boolean useAround();
}
