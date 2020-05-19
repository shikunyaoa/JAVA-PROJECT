package com.kunyao.thread.thread_aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: AQSDemo
 * @Author: kunyao
 * @Description: java层面实现的Monitor锁
 * @Date: 2020/5/19 19:11
 * @Version: 1.0
 */
@Slf4j(topic = "c.AQSDemo")
public class AQSDemo {

    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(()->{
            lock.lock();
            try {
                log.debug("locking....");
            } finally {
                log.debug("unlocking....");
                lock.unlock();
            }

        }, "t1").start();

        new Thread(()->{
            lock.lock();
            try {
                log.debug("locking....");
            } finally {
                log.debug("unlocking....");
                lock.unlock();
            }

        }, "t2").start();
    }
}

class MyLock implements Lock {

    class MySync extends AbstractQueuedSynchronizer{



        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0, 1)){
                //加上了锁，并设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

       public Condition newCondition(){
            return new ConditionObject();
       }
    }

    private MySync sync = new MySync();

    //加锁（不成功会进入等待队列）
    @Override
    public void lock() {
        sync.tryAcquire(1);
    }

    //加锁，可打断
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    //尝试加锁
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    //尝试加锁，带超时
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    //解锁
    @Override
    public void unlock() {
        sync.release(1);
    }

    //条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
