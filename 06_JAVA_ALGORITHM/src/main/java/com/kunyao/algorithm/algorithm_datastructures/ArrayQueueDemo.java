package com.kunyao.algorithm.algorithm_datastructures;

/**
 * @ClassName: ArrayQueueDemo
 * @Author: kunyao
 * @Description: 数组实现的队列
 * @Date: 2020/6/6 18:32
 * @Version: 1.0
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}


class ArrayQueue{

    private int maxSize;
    private int font;
    private int tail;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        //指向队列头的前一个位置
        this.font = -1;
        //队列最后一个数据
        this.tail = -1;
        this.array = new int[maxSize];
    }

    public boolean isFull(){
        return tail == maxSize - 1;
    }


    public boolean isEmpty(){
        return font == tail;
    }


    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列以满");
            return;
        }
        tail++;
        array[tail] = n;
    }


    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        font++;
        return array[font];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }

        for (int i = 0; i < array.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i, array[i]);
        }
    }


    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return array[font + 1];
    }
}