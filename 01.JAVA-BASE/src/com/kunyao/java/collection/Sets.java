package com.kunyao.java.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Sets
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/31 9:42
 * @Version: 1.0
 */
public class Sets {

    public static void main(String[] args) {
        //Set实际上相当于只存储key、不存储value的Map
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }
    }



}
/**
 * 在IDEA2019.1 JAVA8的运行环境中的输出结果为
 * ======================================
 * banana
 * orange
 * apple
 * ======================================
 */

