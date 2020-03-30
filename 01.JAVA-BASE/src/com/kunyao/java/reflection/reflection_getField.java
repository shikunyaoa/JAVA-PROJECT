package com.kunyao.java.reflection;

/**
 * @ClassName: reflection_getField
 * @Author: kunyao
 * @Description: 通过反射获取字段
 * @Date: 2020/3/27 17:48
 * @Version: 1.0
 */
public class reflection_getField {


    public static void main(String[] args) {
        Class std = Student.class;


        try {
            //获取public字段
            System.out.println(std.getField("score"));
            //获取继承public字段
            System.out.println(std.getField("name"));
            //获取private字段
            System.out.println(std.getDeclaredField("grade"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    class Student extends Person{

        public int score;

        private int grade;
    }

    class Person{

        public String name;
    }
}
