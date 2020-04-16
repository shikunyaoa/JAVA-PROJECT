package com.kunyao.jvm.jmm;

/**
 * @ClassName: Volatile
 * @Author: kunyao
 * @Description: volatile实现内存可见性，在多个线程同时写的情况下无法保证原子性
 * @Date: 2020/4/16 19:46
 * @Version: 1.0
 */
public class Volatile {

    //在没有volatile修饰的情况下，不会停止
    //volatile用来修改成员变量和静态成员变量，
    // 可以避免线程从自己的工作缓存中 查找变量的值，必须从主存中获取它的值
    public static volatile boolean flag = true;

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            while(flag){

            }
        });

        flag = false;
    }
}
