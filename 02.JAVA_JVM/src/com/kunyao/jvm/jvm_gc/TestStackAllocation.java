package com.kunyao.jvm.jvm_gc;

/**
 * @ClassName: TestStackAllocation
 * @Author: kunyao
 * @Description: 逃逸分析，栈上分配
 * -Xmx1G -Xms1G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * @Date: 2020/5/31 15:00
 * @Version: 1.0
 */
public class TestStackAllocation {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000 ; i++) {
            allocate();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为" + (end - start) + "ms");

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void allocate() {
        User user = new User();
    }

    static class User{

    }
}
