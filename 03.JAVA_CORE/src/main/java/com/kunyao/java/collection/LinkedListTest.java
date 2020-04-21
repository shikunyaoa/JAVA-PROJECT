package com.kunyao.java.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName: LinkedListTest
 * @Author: kunyao
 * @Description: 链表测试
 * @Date: 2020/4/21 21:19
 * @Version: 1.0
 */
public class LinkedListTest {

    public static void main(String[] args) {

        List<String> a = new LinkedList<>();
        a.add("test1");
        a.add("test2");
        a.add("test3");


        List<String> b = new LinkedList<>();
        b.add("test4");
        b.add("test5");
        b.add("test6");

        ListIterator<String> iterator = a.listIterator();
        Iterator<String> iterator1 = b.iterator();

        while(iterator1.hasNext()){
            if(iterator.hasNext()){
                iterator.next();
                iterator.add(iterator1.next());
            }
        }
        System.out.println(a); //[test1, test4, test2, test5, test3, test6]

        iterator1 = b.iterator();
        while (iterator1.hasNext()){
            iterator1.next();
            if(iterator1.hasNext()){
                iterator1.next();
                iterator1.remove();
            }
        }

        System.out.println(b); //[test4, test6]

        a.removeAll(b);
        System.out.println(a);  //[test1, test2, test5, test3]
    }
}
