package com.kunyao.jvm.jvm_classloader;

/**
 * @ClassName: StaticResolution
 * @Author: kunyao
 * @Description: 方法静态解析
 * @Date: 2020/6/1 15:15
 * @Version: 1.0
 */
public class StaticResolution {

    public static void sayHello(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }

    /**
     *   stack=0, locals=1, args_size=1
     *   0: invokestatic  #5                  // Method sayHello:()V
     *   3: return
     */
}
