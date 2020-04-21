package com.kunyao.java.collection;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @ClassName: PriorityQueueTest
 * @Author: kunyao
 * @Description: 优先级队列
 * @Date: 2020/4/21 21:52
 * @Version: 1.0
 */
public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1996,  12 , 8));
        pq.add(LocalDate.of(1997,  12 , 8));
        pq.add(LocalDate.of(1999,  12 , 8));
        pq.add(LocalDate.of(1922,  12 , 8));

        System.out.println("Iterator .........");
        for (LocalDate lo: pq
             ) {
            System.out.println(lo);

        }
        System.out.println("Removing...........");
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }

    /**
     * Iterator .........
     * 1922-12-08
     * 1996-12-08
     * 1999-12-08
     * 1997-12-08
     * Removing...........
     * 1922-12-08
     * 1996-12-08
     * 1997-12-08
     * 1999-12-08
     *
     * 结论：遍历是无序的，而删除总是从最小的开始
     */
}
