package com.kunyao.jvm.jvm_memory.stack;

/**
 * @ClassName: stackoverflow
 * @Author: kunyao
 * @Description: 栈内存溢出 -Xss指定栈的大小
 * @Date: 2020/4/9 20:48
 * @Version: 1.0
 */
public class stackoverflow {

    public static int count = 0;

    public static void main(String[] args) {

        try {
            countNumber();
        } catch (Throwable e) {
            e.printStackTrace();  //java.lang.StackOverflowError
            System.out.println(count); //23709
        }
    }

    public static  void countNumber(){
        count++;
        countNumber();
    }
}
