package com.kunyao.thread.thread_02;

/**
 * @ClassName: NoVisibility
 * @Author: kunyao
 * @Description: 演示多线程中内存可见性问题
 * @Date: 2020/5/7 13:26
 * @Version: 1.0
 */
public class NoVisibility {

    private static  boolean ready = false;
    private static  int number;

    private static  class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }

            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100000 ; i++) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }

    }
}
