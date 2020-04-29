package com.kunyao.thread.thread_03;

/**
 * @ClassName: DCLSingleton
 * @Author: kunyao
 * @Description: 双重检查懒加载单例模式
 * @Date: 2020/4/29 22:22
 * @Version: 1.0
 */
public class DCLSingleton {

    private static volatile DCLSingleton instance = null;

    private DCLSingleton(){

    }

    public static  DCLSingleton getInstance(){
        if(null == instance){
            synchronized (DCLSingleton.class){
                if(null == instance){
                    instance = new DCLSingleton();
                }
            }
        }

        return instance;
    }
}
