package com.kunyao.thread.thread_atomic;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName: UnsafeDemo
 * @Author: kunyao
 * @Description: 底层Unsafe类
 * @Date: 2020/5/16 17:38
 * @Version: 1.0
 */
public class UnsafeDemo {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        //sun.misc.Unsafe@75828a0f
        System.out.println(unsafe);

        //unsafe底层使用偏移量进行操作
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));

        Teacher t = new Teacher();
        unsafe.compareAndSwapObject(t, idOffset, 0, 1);
        unsafe.compareAndSwapObject(t, nameOffset, null, "测试");
        //Teacher(id=0, name=测试)
        System.out.println(t);
    }
}


@Data
class Teacher{

    volatile int id;
    volatile String name;
}