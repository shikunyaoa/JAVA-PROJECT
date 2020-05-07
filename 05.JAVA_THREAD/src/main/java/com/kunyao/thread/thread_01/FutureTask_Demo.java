package com.kunyao.thread.thread_01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: FutureTask_Demo
 * @Author: kunyao
 * @Description: 使用FutureTask创建线程并获取返回结果
 * @Date: 2020/5/6 21:06
 * @Version: 1.0
 */

@Slf4j(topic = "c.FutureTask_Demo")
public class FutureTask_Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running");
                Thread.sleep(1000);

                return 100;
            }
        });

        Thread t = new Thread(task, "t1");
        t.start();

        //task.get() 获取返回结果
        log.debug("{}", task.get());
    }

    /**
     * 21:09:11 [t1] c.FutureTask_Demo - running
     * 21:09:12 [main] c.FutureTask_Demo - 100
     */
}
