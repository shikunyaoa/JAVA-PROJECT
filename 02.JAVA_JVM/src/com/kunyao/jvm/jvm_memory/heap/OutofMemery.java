package com.kunyao.jvm.jvm_memory.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OutofMemery
 * @Author: kunyao
 * @Description: 堆内存溢出异常   -Xms指定堆的大小
 * @Date: 2020/4/9 21:27
 * @Version: 1.0
 */
public class OutofMemery {

    public static void main(String[] args) {
        int i = 0;

        try {
            List<String> list = new ArrayList<>();
            String str = "hello";
            while(true){
                list.add(str);
                str = str + str;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();  //java.lang.OutOfMemoryError: Java heap space
            System.out.println(i); //26
        }
    }
}
