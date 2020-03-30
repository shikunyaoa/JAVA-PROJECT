package com.kunyao.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Maps
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/30 17:53
 * @Version: 1.0
 */
public class Maps {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("test1", 123);
        map.put("test2", 234);
        map.put("test3", 345);

        for (Map.Entry<String, Integer> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey() + ' ' + entry.getValue()); //test2 234   test3 345  test1 123

        }
    }
}
