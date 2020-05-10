package com.kunyao.thread.thread_03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWriteLockDowngrade
 * @Author: kunyao
 * @Description: 读写锁的降级
 * @Date: 2020/5/10 10:50
 * @Version: 1.0
 */
public class ReadWriteLockDowngrade {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void operationWithLockDowngrade(){
        boolean readLockAcquired = false;
        writeLock.lock(); //申请写锁

        try {
            readLock.lock();
            readLockAcquired = true;
        } finally {
            writeLock.unlock();
        }


        if(readLockAcquired){

            try {
                //读取共享数据并据此执行其他操作
            } finally {
                readLock.unlock(); //释放读锁
            }
        }
    }

}
