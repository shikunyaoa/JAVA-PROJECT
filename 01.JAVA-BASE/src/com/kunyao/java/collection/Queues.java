package com.kunyao.java.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: Queues
 * @Author: kunyao
 * @Description: 队列
 * @Date: 2020/3/31 9:34
 * @Version: 1.0
 */
public class Queues {

    public static void main(String[] args) {

        //这是一个List
        List<String> list = new LinkedList<>();
        //面向抽象编程，这是一个Queue
        //add remove element 操作失败后会报错
        //offer peek poll 操作失败后返回null或false
        Queue<String> queue = new LinkedList<>();
        queue.add("apple");
        queue.add("banana");
        queue.add("orange");

        //返回队首元素，但不是删除
        System.out.println(queue.peek()); //apple

        //返回队首元素，并删除
        System.out.println(queue.poll()); //apple

        System.out.println(queue); //[banana, orange]
    }
}
