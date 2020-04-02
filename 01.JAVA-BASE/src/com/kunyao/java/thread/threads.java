package com.kunyao.java.thread;

/**
 * @ClassName: threads
 * @Author: kunyao
 * @Description: 多线程
 * @Date: 2020/4/2 16:16
 * @Version: 1.0
 */
public class threads {

    //在计算机中，一个任务称为一个进程
    //进程中还需要同时执行多个子任务， 在使用word时，可以一边打字，一边进行拼写检查，同时还可以进行后台打印，把子任务称为线程
    //一个进程可以包含一个或多个线程，但至少包含一个线程


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        System.out.println("main start");
        thread.start();  //我是新线程
        //目标.join() 表示把cpu资源让给目标线程，即让目标线程先执行
        thread.join();
        System.out.println("main end");
        //未使用join的结果为：
        /**
         * main start
         * main end
         * 我是新线程
         */

        /**
         * 使用join的结果为：
         *
         * main start
         * 我是新线程
         * main end
         */
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是新线程");
    }
}