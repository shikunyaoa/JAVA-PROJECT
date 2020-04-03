package com.kunyao.java.design_patterns.singleton;

/**
 * @ClassName: Singleton
 * @Author: kunyao
 * @Description: 单例模式
 * @Date: 2020/4/3 14:21
 * @Version: 1.0
 */
public class Singleton {

    //静态字段引用唯一实例
    private static Singleton INSTANCE = new Singleton();
    //私有化构造函数，保证外部无法实例化
    private Singleton() {

    }
    //通过静态方法返回实例
    public static Singleton getSingleton() {
        //延迟加载
        if(INSTANCE == null) {
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
