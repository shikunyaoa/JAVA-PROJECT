package com.kunyao.jvm.jvm_oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName: DirectMemoryOOM
 * @Author: kunyao
 * @Description: 直接内存溢出
 * -XX:MaxDirectMemorySize参数指定直接内存的大小
 * @Date: 2020/5/22 19:12
 * @Version: 1.0
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError
     * 	at sun.misc.Unsafe.allocateMemory(Native Method)
     * 	at com.kunyao.jvm.jvm_oom.DirectMemoryOOM.main(DirectMemoryOOM.java:24)
     */
}

