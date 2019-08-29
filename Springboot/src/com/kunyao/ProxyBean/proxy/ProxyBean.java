package com.kunyao.ProxyBean.proxy;

import com.kunyao.ProxyBean.intercept.Interceptor;
import com.kunyao.ProxyBean.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    //绑定代理对象
    public static  Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理的对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), proxyBean);
        //返回代理对象
        return proxy;
    }

    //处理代理对象方法逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method ,args);
        Object retObject = null;
        try {
            if(this.interceptor.before()){
                retObject = this.interceptor.around(invocation);
            }else{
                retObject = method.invoke(invocation);
            }
        } catch (Exception e) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else{
            this.interceptor.afterReturning();
            return retObject;
        }
        return null;
    }
}
