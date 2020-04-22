package com.kunyao.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MapTest
 * @Author: kunyao
 * @Description: 映射测试
 * @Date: 2020/4/22 19:41
 * @Version: 1.0
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap();
        map.put("1", "String");
        map.put("2", "test2");
        map.put("3", "test3");

        System.out.println(map);

        map.remove("1");

        map.put("4", "test4");


        System.out.println(map.get("2"));


        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }

    /**
     * {1=String, 2=test2, 3=test3}
     *
     * test2
     *
     * key=2, value=test2
     * key=3, value=test3
     * key=4, value=test4
     */
}

