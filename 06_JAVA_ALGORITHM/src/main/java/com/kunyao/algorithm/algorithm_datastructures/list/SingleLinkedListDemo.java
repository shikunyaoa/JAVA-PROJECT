package com.kunyao.algorithm.algorithm_datastructures.list;

/**
 * @ClassName: SingleLinkedList
 * @Author: kunyao
 * @Description: 单向链表
 * @Date: 2020/6/7 16:40
 * @Version: 1.0
 */
public class SingleLinkedListDemo {

}

//定义SingledLinkedList管理节点
class SingleLinkedList{

    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode newNode){

        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addBefore(HeroNode heroNode){
        HeroNode temp = head;
        //添加节点是否存在
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }

            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            System.out.println("该节点已存在");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    public void update(HeroNode heroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
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
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }

            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }
    }

    public void List(){
        if(head.next == null){
            return;
        }
        //因为头结点不能动，所以需要辅助变量
        HeroNode temp = head.next;
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
class HeroNode{

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}