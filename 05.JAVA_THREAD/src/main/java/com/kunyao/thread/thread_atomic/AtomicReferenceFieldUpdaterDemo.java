package com.kunyao.thread.thread_atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @ClassName: AtomicReferenceFieldUpdaterDemo
 * @Author: kunyao
 * @Description: 具有原子性的字段更新器
 * @Date: 2020/5/16 16:38
 * @Version: 1.0
 */
public class AtomicReferenceFieldUpdaterDemo {

    public static void main(String[] args) {

        Student stu = new Student();
        //参数1: 对象类型
        //参数2：字段类型
        //参数3：字段名称
        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        System.out.println(updater.compareAndSet(stu, null, "测试")); //true
    }
}


class Student{

    volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}