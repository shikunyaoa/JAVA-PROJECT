package com.kunyao.thread.thread_01;

/**
 * @ClassName: CreateThread
 * @Author: kunyao
 * @Description: 继承Thread类创建线程
 * @Date: 2020/4/29 13:45
 * @Version: 1.0
 */
public class CreateThread {

    public static void main(String[] args) {

        Demo1 demo1 = new Demo1();
        //启动线程，请求java虚拟机运行相应的线程，最终由调度器决定是否运行该线程，可能执行，也可能永远不执行
        demo1.start();

        System.out.printf("1.welcome %s %n", Thread.currentThread().getName());
    }

    /**
     * 1.welcome main
     * 2.welcome Thread-0
     */
}


class Demo1 extends Thread{
    @Override
    public void run() {
        System.out.printf("2.welcome %s %n", Thread.currentThread().getName());
    }
}

