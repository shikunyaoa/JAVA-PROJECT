package com.kunyao.thread.thread_01;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Thread_Demo
 * @Author: kunyao
 * @Description: 使用thread创建线程
 * @Date: 2020/5/6 20:44
 * @Version: 1.0
 */
@Slf4j(topic = "c.Thread_Demo")
public class Thread_Demo {


    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run() {
                log.debug("running");
            }
        };

        t.setName("t1");
        t.start();


        log.debug("running");
    }

    /**
     * 20:47:00 [main] c.Thread_Demo - running
     * 20:47:00 [t1] c.Thread_Demo - running
     */
}
