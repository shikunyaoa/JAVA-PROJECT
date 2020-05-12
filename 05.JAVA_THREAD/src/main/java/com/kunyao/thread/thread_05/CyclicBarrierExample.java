package com.kunyao.thread.thread_05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierExample
 * @Author: kunyao
 * @Description: 栅栏的用法
 * @Date: 2020/5/12 16:41
 * @Version: 1.0
 */
public class CyclicBarrierExample {
    //参与的士兵
    final Soldier[][] rank;
    //靶的个数
    final int N;
    //打靶持续时间
    final int lasting;
    //标识是否继续打靶
    volatile boolean done = false;
    //用来指示进行下一轮打靶的是那一排的士兵
    volatile int nextLine = 0;
    final CyclicBarrier shiftBarrier;
    final CyclicBarrier startBarrier;


    public CyclicBarrierExample(int N, final int lineCount, int lasting) {
        this.N = N;
        this.lasting = lasting;
        this.rank = new Soldier[lineCount][N];
        for (int i = 0; i < lineCount ; i++) {
            for (int j = 0; j <N ; j++) {
                rank[i][j] = new Soldier(i * N + j);
            }
        }
        //第二个参数定义的任务会在最后一个线程执行CyclicBarrier.await()方法时运行
        shiftBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                nextLine = (nextLine + 1) % lineCount;

            }
        });
        startBarrier = new CyclicBarrier(N);
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierExample cyclicBarrierExample = new CyclicBarrierExample(4, 5, 24);
        cyclicBarrierExample.start();
    }

    public void start() throws InterruptedException {
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Shooting(i);
            threads[i].start();
        }

        Thread.sleep(lasting * 1000);
        stop();
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void stop(){
        done = true;
    }

    class Shooting extends Thread{
        final int index;

        public Shooting(int index){
            this.index = index;
        }

        @Override
        public void run() {
            Soldier soldier;

            try {
                while(!done){
                    soldier = rank[nextLine][index];
                    //一排的士兵必须同时开始射击
                    startBarrier.await();
                    soldier.fire();
                    //一排中的士兵必须等待该排中的其他士兵设计完毕才能离开射击点
                    shiftBarrier.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class Soldier{
        private final int seqNo;

        public Soldier(int seqNo) {
            this.seqNo = seqNo;
        }

        public void fire(){

        }
    }
}
