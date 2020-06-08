package com.kunyao.algorithm.algorithm_datastructures.list;

/**
 * @ClassName: Josepfu
 * @Author: kunyao
 * @Description: 约瑟夫问题 - 单向循环链表
 * @Date: 2020/6/8 19:24
 * @Version: 1.0
 */
public class Josepfu {
}

class CircleSingleLinkedList{

    Boy first = null;

    public void add(int num){

        if(num < 1){
            System.out.println("num的值不正确");
            return;
        }

        Boy curBoy = null;

        for (int i = 0; i < num ; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    public void list(){
        if(first == null){
            return;
        }

        Boy curBoy = first;
        while(true){
            System.out.printf("%d \n", curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }


    /**
     *
     * @param startNo 表示第几个小孩开始数数
     * @param countNo 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNo, int nums){
        if(startNo < 1 || startNo > nums || first == null){
            return;
        }

        Boy helper = first;
        while(true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo - 1 ; i++) {
            first.getNext();
            helper.getNext();
        }

        while(true){
            if(helper == first){
                break;
            }

            for (int i = 0; i < countNo - 1 ; i++) {
                first.getNext();
                helper.getNext();
            }
            //将当前节点移出链表
            first = first.getNext();
            helper.setNext(first);
        }
    }
}

class Boy{

    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}


