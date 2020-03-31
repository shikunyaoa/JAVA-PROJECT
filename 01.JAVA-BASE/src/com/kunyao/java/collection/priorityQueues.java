package com.kunyao.java.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName: priorityQueues
 * @Author: kunyao
 * @Description: 优先级队列
 * @Date: 2020/3/31 9:48
 * @Version: 1.0
 */
public class priorityQueues {

    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }

}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if(o1.number.charAt(0) == o2.number.charAt(0)){
            return o1.number.compareTo(o2.number);
        }
        if(o1.number.charAt(0) == 'V'){
            return -1;
        }else{
            return 1;
        }
    }
}

class User{
    public final String name;
    public final String number;


    public User(String name, String number){
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString(){
        return name + "/" +number;
    }
}