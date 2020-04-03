package com.kunyao.java.design_patterns.factory_method;

/**
 * @ClassName: Factory
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 13:41
 * @Version: 1.0
 */

/**
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
 * 工厂方法的目的是使得创建对象和使用对象是分离的，并且客户端总是引用抽象工厂和抽象产品
 */
public interface Factory {
    Number parse(String s);
}
