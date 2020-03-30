package com.kunyao.java.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: reflection_proxy
 * @Author: kunyao
 * @Description: 动态代理
 * @Date: 2020/3/30 14:51
 * @Version: 1.0
 */
public class reflection_proxy {

    public static void main(String[] args) {
        //静态代理：通过编写接口的实现类，父类引用执行实例对象的形式称为静态代理
        //动态代理：没有实现类但是在运行时动态创建一个接口对象的方式称为动态代理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("good morning " + args[0]);  //good morning bob
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),   //传入ClassLoader
                new Class[]{Hello.class},  //传入要实现的接口
                handler        //传入处理调用方法的InvocationHandler
        );
        hello.morning("bob");

    }

}

interface Hello{

    void morning(String name);
}

/**
 * 在IDEA2019.3.1 JAVA8 的运行环境中的输出结果：
 * =========================================================================
 *  good morning bob
 * ==========================================================================
 */