package com.kunyao.thread.thread_01;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Runnable_Demo
 * @Author: kunyao
 * @Description: 使用Runnable创建线程
 * @Date: 2020/5/6 20:50
 * @Version: 1.0
 */
@Slf4j(topic = "c.Runnable_Demo")
public class Runnable_Demo {


    public static void main(String[] args) {

        //Runnable是对任务的抽象

        Thread t = new Thread(() -> log.debug("running"), "t2");
        t.start();

    }

    /**
     * 20:52:33 [t2] c.Runnable_Demo - running
     */
}
