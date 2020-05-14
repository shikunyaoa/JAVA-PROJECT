package com.kunyao.thread.thread_08;

import jdk.nashorn.internal.runtime.Debug;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;

/**
 * @ClassName: TheadMonitorDemo
 * @Author: kunyao
 * @Description: 线程的未捕获异常（Uncaught Exception）
 * @Date: 2020/5/14 17:40
 * @Version: 1.0
 */

@Slf4j(topic = "c.TheadMonitorDemo")
public class TheadMonitorDemo {

    volatile boolean inited = false;
    static int threadIndex = 0;
    final BlockingQueue<String> channel = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) throws InterruptedException {
        TheadMonitorDemo demo = new TheadMonitorDemo();
        demo.init();
        for (int i = 0; i < 100 ; i++) {
            demo.service("test-" + i);
        }
        Thread.sleep(2000);
        System.exit(0);
    }

    public synchronized void init(){
        if(inited){
            return;
        }
        log.debug("init........");
        WorkerThread t = new WorkerThread();
        t.setName("Worker0-" + threadIndex++);
        t.setUncaughtExceptionHandler(new ThreadMonitor());
        t.start();
        inited = true;
    }


    public void service(String message) throws InterruptedException{
        channel.put(message);
    }

    private class ThreadMonitor implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.debug("Current thread is t:{}, it is still alive:{}", Thread.currentThread() == t, t.isAlive());

            String threadInfo = t.getName();
            log.debug((Marker) Level.SEVERE, threadInfo + " terminated:", e );

            log.debug("About to restart" + threadInfo);
            inited = false;
            init();
        }

    }


    private class  WorkerThread extends Thread{
        @Override
        public void run() {
            log.debug("Do something important");
            String msg;

            try {
                for(;;){
                    msg = channel.take();
                    process(msg);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void process(String message){
            log.debug(message);
            if(((int)Math.random() * 100) < 2){
                throw new RuntimeException("test");
            }


        }
    }
}
