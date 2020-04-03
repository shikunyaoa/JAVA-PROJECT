package com.kunyao.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: thread_threadPool
 * @Author: kunyao
 * @Description: 线程池
 * @Date: 2020/4/3 9:58
 * @Version: 1.0
 */
public class thread_threadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            executorService.submit(new Task(" " + i));
        }
        executorService.shutdown();
    }
}

class Task implements Runnable{
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("hello" + name);
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }

    }
}