package com.kunyao.algorithm.algorithm_datastructures.queue;

/**
 * @ClassName: CircleArrayQueueDemo
 * @Author: kunyao
 * @Description: 数组实现的环形队列
 * @Date: 2020/6/6 19:17
 * @Version: 1.0
 */
public class CircleArrayQueueDemo {

}



class CircleArray{

    private int maxSize;
    //指向第一个元素
    private int font;
    //指向最后一个元素的后一位
    private int tail;
    private int[] array;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    public boolean isFull(){
        return (tail + 1) % maxSize == font;
    }


    public boolean isEmpty(){
        return font == tail;
    }


    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列以满");
            return;
        }
        array[tail] = n;
        tail = (tail + 1) % maxSize;
    }


    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = array[font];
        font = (font + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }

        for (int i = font; i < font + size() ; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize, array[i % maxSize]);
        }
    }

    public int size(){
        return (tail + maxSize - font) % maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return array[font];
    }
}