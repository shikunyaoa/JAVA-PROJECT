package com.kunyao.algorithm.algorithm_datastructures.list;

/**
 * @ClassName: DoubleLinkedListDemo
 * @Author: kunyao
 * @Description: 双向链表
 * @Date: 2020/6/7 20:11
 * @Version: 1.0
 */
public class DoubleLinkedListDemo {
}

class DoubleLinkedList{

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }


    public void add(HeroNode2 newNode){

        HeroNode2 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //形成双向链表
        temp.next = newNode;
        newNode.pre = temp;
    }

    public void update(HeroNode2 heroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }

            if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else{
            System.out.println("该节点不存在");
        }

    }


    public void remove(int no){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }

            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

        }
    }


    public void List(){
        if(head.next == null){
            return;
        }
        //因为头结点不能动，所以需要辅助变量
        HeroNode2 temp = head.next;
        while(true){
            if(temp.next == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//创建节点
class HeroNode2{

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}