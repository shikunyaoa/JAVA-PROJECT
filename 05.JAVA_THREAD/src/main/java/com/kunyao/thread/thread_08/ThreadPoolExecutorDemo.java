package com.kunyao.thread.thread_08;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolExecutorDemo
 * @Author: kunyao
 * @Description: 线程池demo
 * @Date: 2020/5/18 9:19
 * @Version: 1.0
 */
public class ThreadPoolExecutorDemo {


    public static void main(String[] args) {

        ThreadFactory namedThreadFactory = null;
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    }
}
