package com.kunyao.java.design_patterns.adapter;

import java.util.concurrent.Callable;

/**
 * @ClassName: Task
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 14:32
 * @Version: 1.0
 */
public class Task implements Callable<Long> {

    private Long num;

    public Task(long num){
        this.num = num;
    }
    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }
}
