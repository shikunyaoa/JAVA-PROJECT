package com.kunyao.jvm.jvm_classloader;

/**
 * @ClassName: ClassInitDemo
 * @Author: kunyao
 * @Description: 类的初始化
 * @Date: 2020/5/25 21:27
 * @Version: 1.0
 */
public class ClassInitDemo {

    private static int num = 1;

    static {
        num = 2;
    }


    public static void main(String[] args) {
        System.out.println(ClassInitDemo.num);
    }

    /**
     * <clinit>: 将所有类变量显示初始化和静态代码块合并的方法
     * 0 iconst_1
     * 1 putstatic #3 <com/kunyao/jvm/jvm_classloader/ClassInitDemo.num>
     * 4 iconst_2
     * 5 putstatic #3 <com/kunyao/jvm/jvm_classloader/ClassInitDemo.num>
     * 8 return
     */
}
