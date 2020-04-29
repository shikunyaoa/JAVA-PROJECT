package com.kunyao.thread.thread_01;

/**
 * @ClassName: ThreadCreationCmp
 * @Author: kunyao
 * @Description: 两种创建线程的方式进行比较
 * @Date: 2020/4/29 14:12
 * @Version: 1.0
 */
public class ThreadCreationCmp {


    public static void main(String[] args) {
        Thread t;
        ThreadTask ct = new ThreadTask() ;

       final int i = Runtime.getRuntime().availableProcessors();


        for (int j = 0; j < 2 * i ; j++) {
            t = new CountThread();
            t.start();

            /**
             * 继承Thread的输出始终为100
             */
        }

        for (int j = 0; j < 2 * i ; j++) {
            t = new Thread(ct);
            t.start();

            /**
             * 实现Runnable的输出小于800大于700
             */
        }
    }



    static class Counter{

        private int count = 0;

        public void increment(){
            count++;
        }


        public int value(){
            return count;
        }
    }

    static class ThreadTask implements Runnable{

        private Counter counter = new Counter();

        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println(counter.value());
        }

        private void doSomething(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CountThread extends Thread{

        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }

            System.out.println(counter.value());
        }

        private void doSomething(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

