package com.kunyao.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: List
 * @Author: kunyao
 * @Description: 集合
 * @Date: 2020/3/30 17:44
 * @Version: 1.0
 */
public class Lists {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(20);
        list.add(49);
        //使用toArray(T[])的形式将集合转换为数组不会丢失类型信息
        //foreach本身会Iterator进行遍历，具有最高的访问效率
        Integer[] integers = list.toArray(new Integer[3]);
        for ( Integer res: integers
             ) {
            System.out.println(res); //12 20 49
        }


    }
}
