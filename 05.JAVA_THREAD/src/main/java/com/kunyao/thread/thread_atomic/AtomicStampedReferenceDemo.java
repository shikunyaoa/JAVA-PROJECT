package com.kunyao.thread.thread_atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

import static java.lang.Thread.sleep;

/**
 * @ClassName: AtomicStampedReferenceDemo
 * @Author: kunyao
 * @Description: 解决ABA问题的原子引用
 * @Date: 2020/5/16 10:49
 * @Version: 1.0
 */
@Slf4j(topic = "c.AtomicStampedReferenceDemo")
public class AtomicStampedReferenceDemo {

    private static  AtomicStampedReference<String> t = new AtomicStampedReference<String>("A", 0);


    public static void main(String[] args) throws InterruptedException {

        //获取引用值
        String reference = t.getReference();
        //获取版本号
        int stamp = t.getStamp();
        log.debug("{}", stamp);
        update();
        sleep(1);
        log.debug("A -> C {}", t.compareAndSet(reference, "C", stamp, stamp + 1));
    }


    public static void update() throws InterruptedException {
        new Thread(()->{
            String reference = t.getReference();
            int stamp = t.getStamp();
            log.debug("{}", stamp);
            log.debug("A -> B {}" ,t.compareAndSet(reference, "B", stamp,stamp + 1));

        }, "t1").start();
        sleep((long) 0.5);
        new Thread(()->{
            String reference = t.getReference();
            int stamp = t.getStamp();
            log.debug("{}", stamp);
            log.debug("B -> A {}", t.compareAndSet(reference, "A", stamp,stamp + 1));
        }, "t2").start();
    }
}
