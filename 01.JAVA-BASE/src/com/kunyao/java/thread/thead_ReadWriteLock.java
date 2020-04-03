package com.kunyao.java.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: thead_ReadWriteLock
 * @Author: kunyao
 * @Description: 悲观读写锁：读的过程中拒绝有写入，也就是写入必须等待
 * @Date: 2020/4/3 9:22
 * @Version: 1.0
 */


public class thead_ReadWriteLock {
    //创建读写锁
    /**
     * 使用ReadWriteLock可以解决这个问题，它保证：
     *
     * 只允许一个线程写入（其他线程既不能写入也不能读取）；
     * 没有写入时，多个线程允许同时读（提高性能）
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //获取读锁
    private final Lock rlock = readWriteLock.readLock();
    //获取写锁
    private final Lock wlock = readWriteLock.writeLock();

    private int[] count = new int[10];

    public void set(int index) {
        wlock.lock();

        try {
            count[index] += 1;

        }finally {
            wlock.unlock();
        }
    }


    public int[] get() {
        rlock.lock();
        try {
            return Arrays.copyOf(count, count.length);
        } finally {
            rlock.unlock();
        }
    }
}


