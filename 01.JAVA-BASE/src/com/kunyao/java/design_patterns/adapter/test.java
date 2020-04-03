package com.kunyao.java.design_patterns.adapter;

import java.util.concurrent.Callable;

/**
 * @ClassName: test
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 14:34
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        Callable<Long> callable = new Task(123450000L);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
