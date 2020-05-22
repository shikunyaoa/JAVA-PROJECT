package com.kunyao.jvm.jvm_oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: JavaMethodAreaOOM
 * @Author: kunyao
 * @Description: Java方法区内存溢出
 * @Date: 2020/5/22 19:44
 * @Version: 1.0
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
        }
    }

    static class  OOMObject{

    }
}
