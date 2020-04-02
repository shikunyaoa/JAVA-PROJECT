package com.kunyao.java.thread;

/**
 * @ClassName: thread_synchronized
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/2 17:19
 * @Version: 1.0
 */
public class thread_synchronized {

    public static void main(String[] args) throws Exception {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

    /**
     * 未加synchronized前的输出结果为：
     * -43
     * 结论：多线程模型下，要保证逻辑正确，对共享变量进行读写时，必须保证一组指令以原子方式执行：即某一个线程执行时，其他线程必须等待：
     */

    /**
     * 加了synchronized的输出结果为：
     * 0
     * 结论：加锁实现了安全访问同一个共享变量
     */

}
class Counter {
    public static final Object lock = new Object();
    public static int count = 0;


    public synchronized void add(int n) {
        if (n < 0) {
            //JVM允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做可重入锁
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            //保证一段代码的原子性就是通过加锁和解锁实现的。Java程序使用synchronized关键字对一个对象进行加锁：
            synchronized (Counter.lock){
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized (Counter.lock){
                Counter.count -= 1;
            }
        }
    }
}