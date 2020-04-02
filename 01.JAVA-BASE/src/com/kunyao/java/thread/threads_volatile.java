package com.kunyao.java.thread;

/**
 * @ClassName: threads
 * @Author: kunyao
 * @Description: 中断线程
 * @Date: 2020/4/2 16:16
 * @Version: 1.0
 */
public class threads_volatile {


    public static void main(String[] args) throws InterruptedException {
        MyThreads2 thread = new MyThreads2();
        thread.start();
        Thread.sleep(1);
        //使用标志位标识线程是否继续执行
        thread.running = false;
        /**
         * 输出结果为：
         * 1hello
         * 2hello
         * 3hello
         * 4hello
         * 5hello
         * 6hello
         * 7hello
         * 8hello
         * 9hello
         * 10hello
         * 11hello
         * 12hello
         * 13hello
         * 14hello
         * 15hello
         * 16hello
         * 17hello
         * 18hello
         * 19hello
         * end
         */
    }
}


class MyThreads2 extends Thread {
    //使用volatile关键字标记共享变量，确保每个线程都可以读取到更新后的变量值
    /**
     * 这涉及到Java的内存模型。在Java虚拟机中，
     * 变量的值保存在主内存中，但是，当线程访问变量时，它会先获取一个副本，并保存在自己的工作内存中。
     * 如果线程修改了变量的值，虚拟机会在某个时刻把修改后的值回写到主内存，但是，这个时间是不确定的！
     *
     * 因此，volatile关键字的目的是告诉虚拟机：
     *
     * 每次访问变量时，总是获取主内存的最新值；
     * 每次修改变量后，立刻回写到主内存。
     */
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        //检查自身interrupted状态
        while(running){
            n ++;
            System.out.println(n + "hello");
        }
    }
}