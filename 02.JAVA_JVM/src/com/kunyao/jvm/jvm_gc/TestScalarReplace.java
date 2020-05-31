package com.kunyao.jvm.jvm_gc;

/**
 * @ClassName: TestScalarReplace
 * @Author: kunyao
 * @Description: 逃逸分析，标量替换
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:+EliminateAllocations
 * @Date: 2020/5/31 15:21
 * @Version: 1.0
 */
public class TestScalarReplace {

    public static class User{
        public int id;
        public String name;
    }

    public static void alloc(){
        User user = new User();
        user.id = 5;
        user.name = "标量替换";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000 ; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为" + (end - start) + "ms");
    }
}
