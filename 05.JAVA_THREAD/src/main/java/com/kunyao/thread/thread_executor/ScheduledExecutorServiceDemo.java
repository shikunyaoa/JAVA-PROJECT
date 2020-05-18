package com.kunyao.thread.thread_executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @ClassName: ScheduledExecutorServiceDemo
 * @Author: kunyao
 * @Description: 任务调度线程池
 * @Date: 2020/5/18 20:13
 * @Version: 1.0
 */
@Slf4j(topic = "c.ScheduledExecutorServiceDemo")
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        //循环执行某个任务
//        pool.scheduleAtFixedRate(()->{
//            log.debug("running.....");
//        },1,1, TimeUnit.SECONDS);
//

        //参数3：任务之间的时间间隔
        pool.scheduleWithFixedDelay(()->{
            log.debug("running.....");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 3,TimeUnit.SECONDS);
    }

}
