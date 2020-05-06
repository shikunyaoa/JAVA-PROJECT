package com.kunyao.thread.thread_08;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

import java.io.File;
import java.util.concurrent.*;

/**
 * @ClassName: FutureTaskDemo
 * @Author: kunyao
 * @Description: 使用Future获取任务的处理结果数据
 * @Date: 2020/5/4 18:33
 * @Version: 1.0
 */
public class FutureTaskDemo {

    final static int N_CPU = Runtime.getRuntime().availableProcessors();
    final ThreadPoolExecutor executor = new ThreadPoolExecutor(0, N_CPU * 2, 4, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        FutureTaskDemo demo = new FutureTaskDemo();
        Future<String> future = demo.recognizeImage("");
        doSomething();

    }


    private static void doSomething(){

    }

    public Future<String> recognizeImage(final String imageFile){
        return executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doRecognizeImage(new File(imageFile));
            }
        });
    }


    protected String doRecognizeImage(File imageFIle){
        return null;
    }
}
