package com.kunyao.thread.thread_05;



import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: TimeoutWaitWithCondition
 * @Author: kunyao
 * @Description: 使用条件变量实现等待超时控制
 * @Date: 2020/5/2 10:09
 * @Version: 1.0
 */
public class TimeoutWaitWithCondition {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean ready = false;
    protected static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Thread t  = new Thread(){
            @Override
            public void run() {
                for(;;){
                    lock.lock();

                    try {
                        ready = random.nextInt(100) < 5 ? true : false;
                        if(ready){
                            condition.signal();
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
        waiter(1000);
    }

    private static void waiter(final long timeout) throws InterruptedException {
        if(timeout < 0){
            throw new IllegalArgumentException();
        }

        final Date deadline = new Date(System.currentTimeMillis() + timeout);
        boolean continueToWait = true;
        lock.lock();

        try {
            while(!ready){
                //等待未超时，继续等待
                if(!continueToWait){
                    //等待超时退出
                    return;
                }
                //Condition.awaitUntil(Date)返回值true表示进行的等待尚未达到最后期限
                //否则返回false
                continueToWait = condition.awaitUntil(deadline);
            }
            guarededActon();
        } finally {
            lock.unlock();
        }


    }

    private static void guarededActon() {
    }
}
