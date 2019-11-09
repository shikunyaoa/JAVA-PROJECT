package com.kunyao.springboots.chapter4.proxy;

import com.kunyao.springboots.chapter4.intercept.Interceptor;
import com.kunyao.springboots.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyBean
 * @Description 实现ProxyBean
 * @Author kunyao
 * @Date $
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    /**
     * 绑定代理对象
     * @param target
     * @param interceptor
     * @return
     */
    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), proxyBean);
        //返回代理对象
        return proxy;
    }

    /**
     * 处理代理对象方法逻辑
     * @param proxy
     * @param method
     * @param args
     * @return 方法调用结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args, method, target);
        Object retObj = null;
        try {
            if(this.interceptor.before()){
                retObj = this.interceptor.around(invocation);
            }else{
                retObj = method.invoke(target, args);
            }
        } catch (Exception e) {
           exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else{
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
