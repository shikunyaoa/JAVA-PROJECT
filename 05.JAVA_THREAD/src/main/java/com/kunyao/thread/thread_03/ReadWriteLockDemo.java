package com.kunyao.thread.thread_03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWriteLockDemo
 * @Author: kunyao
 * @Description: 读写锁实例
 * @Date: 2020/4/29 20:55
 * @Version: 1.0
 */
public class ReadWriteLockDemo {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void reader(){
        readLock.lock(); //申请读锁

        try {
            System.out.println("");
        } finally {
            readLock.unlock(); //释放读锁， 以免锁泄露
        }
    }

    public void writer(){
        writeLock.lock(); //申请写锁

        try {
            System.out.println("");
        } finally {
            writeLock.unlock(); //释放写锁
        }
    }
}
