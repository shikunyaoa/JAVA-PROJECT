package com.kunyao.thread.thread_05;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ConditionUsage
 * @Author: kunyao
 * @Description: 条件变量
 * @Date: 2020/5/2 9:51
 * @Version: 1.0
 */
public class ConditionUsage {
    
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private volatile boolean flag = true;
    public void aGuaredMethod() throws Exception {
        lock.lock();

        try {
            while(flag){
                condition.await();
            }
            doAction();
        } finally {
            lock.unlock();
        }
    }

    private void doAction() {
    }
    
    
    public void anNotificationMethod() throws Exception{
        lock.lock();

        try {
            changeState();
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    private void changeState() {
    }

}
