package com.kunyao.java.design_patterns.adapter;

import java.util.concurrent.Callable;

/**
 * @ClassName: RunnableAdapter
 * @Author: kunyao
 * @Description: 适配器模式将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * @Date: 2020/4/3 14:33
 * @Version: 1.0
 */
public class RunnableAdapter implements Runnable {
    // 引用待转换接口:
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    // 实现指定接口:
    @Override
    public void run() {
        // 将指定接口调用委托给转换接口调用:
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}