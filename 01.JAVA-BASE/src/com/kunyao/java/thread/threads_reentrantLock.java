package com.kunyao.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: threads
 * @Author: kunyao
 * @Description: 中断线程
 * @Date: 2020/4/2 16:16
 * @Version: 1.0
 */
public class threads_reentrantLock {


    public static void main(String[] args) throws InterruptedException {

    }
}


class Counters {
    //java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) throws InterruptedException {
        //ReentrantLock可以尝试获取锁
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {

            } finally {
                lock.unlock();
            }
        }
    }
}