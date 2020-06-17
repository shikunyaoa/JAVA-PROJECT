package com.kunyao.algorithm.algorithm_datastructures.tree;

/**
 * @ClassName: BinaryTreeDemo
 * @Author: kunyao
 * @Description: 二叉树
 * @Date: 2020/6/17 19:49
 * @Version: 1.0
 */
public class BinaryTreeDemo {
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }

    }

    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }

    }

    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }


    public HeroNode preOrderSearch(int no){
        if(this.root != null){
            return this.root.preOrderSearch(no);
        }

        return null;
    }

    public HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return this.root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no){
        if(this.root != null){
            return this.root.postOrderSearch(no);
        }

        return null;
    }
}

class HeroNode{

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);

        if(this.left != null){
            this.preOrder();
        }

        if(this.right != null){
            this.preOrder();
        }
    }


    /*
    中序遍历
     */
    public void infixOrder(){

        if(this.left != null){
            this.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.infixOrder();
        }
    }


    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.left != null){
            this.postOrder();
        }

        if(this.right != null){
            this.postOrder();
        }

        System.out.println(this);
    }


    /**
     * 前序遍历查找
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }
        
        HeroNode heroNode = null;
        if(this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }
        
        if(heroNode != null){
            return heroNode;
        }


        if(this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }

    /**
     * 中序遍历查找
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no){
        HeroNode heroNode = null;
        if(this.left != null){
            heroNode = this.left.infixOrderSearch(no);
        }

        if(heroNode != null){
            return heroNode;
        }

        if(this.no == no){
            return this;
        }

        if(this.right != null){
            heroNode = this.right.infixOrderSearch(no);
        }

        return heroNode;
    }


    /**
     * 后序遍历查找
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;

        if(this.left != null){
            heroNode = this.left.postOrderSearch(no);
        }

        if(heroNode != null){
            return heroNode;
        }

        if(this.right != null){
            heroNode = this.right.postOrderSearch(no);
        }

        if(heroNode != null){
            return heroNode;
        }

        if(this.no == no){
            return this;
        }

        return heroNode;

    }

}