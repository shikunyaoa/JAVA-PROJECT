package com.kunyao.thread.thread_02;

/**
 * @ClassName: SpeculativeLoadExample
 * @Author: kunyao
 * @Description: 处理器猜测执行技术的实例
 * @Date: 2020/5/9 14:36
 * @Version: 1.0
 */
public class SpeculativeLoadExample {

    private boolean ready = false;
    private int[] data = new int[]{1,2,3,4,5,6,7,8};

    public void writer(){
        int[] newData = new int[]{1,2,3,4,5,6,7,8};
        for (int i = 0; i < newData.length; i++) {
            newData[i] = newData[i] - i;
        }
        data = newData;
        ready = true;
    }


    public int reader(){
        int sum = 0;
        int[] snapshot;
        if(ready){
            snapshot = data;
            for (int i = 0; i < snapshot.length ; i++) {
                sum += snapshot[i];
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        SpeculativeLoadExample speculativeLoadExample = new SpeculativeLoadExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    speculativeLoadExample.writer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    speculativeLoadExample.reader();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();


    }

    /**
     *输出结果为： 0
     *结论：reader()方法中的if语句体先与语句条件执行了
     */
}
