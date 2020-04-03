package com.kunyao.java.thread;

import java.util.concurrent.*;

/**
 * @ClassName: thread_threadPool
 * @Author: kunyao
 * @Description: Java标准库还提供了一个Callable接口，和Runnable接口比，它多了一个返回值：
 * @Date: 2020/4/3 9:58
 * @Version: 1.0
 */
public class thread_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> task = new Tasks();
        Future<String> future = executorService.submit(task);
        String result = future.get(); //从future中获取返回结果
    }
}

/**
 * 获取任务返回的结果
 */
class Tasks implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Future";
    }
}