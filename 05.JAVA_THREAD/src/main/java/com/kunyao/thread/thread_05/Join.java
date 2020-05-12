package com.kunyao.thread.thread_05;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Join
 * @Author: kunyao
 * @Description: Join方法测试
 * @Date: 2020/5/12 15:50
 * @Version: 1.0
 */
@Slf4j(topic = "c.Join")
public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{

            log.debug("爷先执行了");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        t1.join();
        log.debug("我也执行了");
    }
}
