package com.kunyao.thread.thread_05;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchExample
 * @Author: kunyao
 * @Description: 倒计时协调器CountDownLatch
 * @Date: 2020/5/2 19:27
 * @Version: 1.0
 */
public class CountDownLatchExample {

    private static final CountDownLatch latch = new CountDownLatch(4);
    private static int data;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    data = i;
                    latch.countDown();
                }
            }
        };

        workerThread.start();
        //当倒计时计数器为0时返回，唤醒其他等待的线程
        latch.await();

        //结果为3
        System.out.println(data);
    }
}
