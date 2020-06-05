package com.kunyao.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ArrayList_Analysis
 * @Author: kunyao
 * @Description: ArrayList源码分析
 * @Date: 2020/6/4 11:28
 * @Version: 1.0
 */
public class ArrayList_Analysis {


    public static void main(String[] args) {

        List<String> list = new ArrayList();

        list.add("测试3");
        list.add("测试32");
        list.add("测试4");

        List<String> list1 = new ArrayList<>();
        list.add("测试3");
        list.retainAll(list1);
    }
}
