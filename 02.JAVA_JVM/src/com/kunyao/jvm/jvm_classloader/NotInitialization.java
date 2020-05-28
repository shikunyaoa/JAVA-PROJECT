package com.kunyao.jvm.jvm_classloader;

/**
 * @ClassName: NotInitialization
 * @Author: kunyao
 * @Description: 被动引用实例
 * @Date: 2020/5/28 22:15
 * @Version: 1.0
 */
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
        /**
         * SuperClass init!
         * 123
         *
         * 结论：对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发
         * 父类的初始化而不会触发子类的初始化
         */
    }


}


class SuperClass{

    public static int value = 123;

    static {
        System.out.println("SuperClass init!");
    }

}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}