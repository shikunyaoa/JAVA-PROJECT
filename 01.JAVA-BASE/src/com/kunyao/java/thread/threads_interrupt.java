package com.kunyao.java.thread;

/**
 * @ClassName: threads
 * @Author: kunyao
 * @Description: 中断线程
 * @Date: 2020/4/2 16:16
 * @Version: 1.0
 */
public class threads_interrupt {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThreads();
        thread.start();
        Thread.sleep(1); //暂停1毫秒
        thread.interrupt(); //interrupt中断线程，向线程发出了"中断请求"
        thread.join();  //等待thread先执行
        System.out.println("end");
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


class MyThreads extends Thread {
    @Override
    public void run() {
        int n = 0;
        //检查自身interrupted状态
        while( !interrupted()){
            n ++;
            System.out.println(n + "hello");
        }
    }
}