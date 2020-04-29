package com.kunyao.thread.thread_01;

/**
 * @ClassName: CreateRunnable
 * @Author: kunyao
 * @Description: 实现Runnable接口创建线程
 * @Date: 2020/4/29 13:53
 * @Version: 1.0
 */
public class CreateRunnable {
    public static void main(String[] args) {

        Thread demo1 = new Thread(new Demo2());
        //启动线程，请求java虚拟机运行相应的线程，最终由调度器决定是否运行该线程，可能执行，也可能永远不执行
        demo1.start();

        System.out.printf("1.welcome %s %n", Thread.currentThread().getName());
    }

    /**
     * 1.welcome main
     * 2.welcome Thread-0
     */
}


class Demo2 implements Runnable{


    public void run() {
        System.out.printf("2.welcome %s %n", Thread.currentThread().getName());
    }
}
