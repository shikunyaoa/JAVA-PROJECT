package com.kunyao.algorithm.algorithm_alogrithms.search;

import com.sun.glass.ui.Size;

/**
 * @ClassName: RedBlackBinarySearchTree
 * @Author: kunyao
 * @Description: 红黑二叉查找树
 * @Date: 2020/7/31 10:58
 * @Version: 1.0
 */
public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;       //由其父结点指向它的连接的颜色

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if(x == null){
            return 0;
        }else{
            return x.N;
        }
    }

    private boolean isRed(Node x){
        if(x == null){
            return false;
        }
        return x.color == RED;
    }


    /**
     * 左旋转
     * @param h
     * @return
     */
    Node rotateLeft(Node h){
        //保存要旋转结点的右子树
        Node x = h.right;
        //将保存节点的左子树设置为要旋转结点的右子树
        h.right = x.left;
        //将保存节点的左子树设置为要旋转结点
        x.left = h;
        //将保存节点的颜色设置为要旋转结点的颜色
        x.color = h.color;
        //将要旋转结点的颜色设置为RED
        h.color = RED;
        //将要保存节点的节点数设置为要旋转结点的节点数
        x.N = h.N;
        //重新计算要旋转结点的结点数并设置
        h.N = 1 + size(h.left) + size(h.right);
        //将新的树的头结点返回
        return x;
    }

    /**
     * 右旋转
     * @param h
     * @return
     */
    Node rotateRight(Node h){
        //保存要旋转结点的左节点
        Node x = h.left;
        //将要旋转结点的左子树设置为保存节点的右子树
        h.left = x.right;
        //将保存节点的右子树设置为要旋转的节点
        x.right = h;
        //将保存节点的颜色设置为要旋转结点的颜色
        x.color = h.color;
        //将要旋转结点的颜色设置为RED
        h.color = RED;
        //将保存结点的结点数设置为要旋转结点的节点数
        x.N = h.N;
        //重新计算h的节点数并设置
        h.N = 1 + size(h.left) + size(h.right);
        //将旋转后的树的根节点返回
        return x;
    }

    //颜色转换，保证整棵红黑树的黑色平衡性
    void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }


    public void put(Key key, Value val){
        //查找key,找到则更新其值，否则为它新键一个结点
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val){
        if(h == null){
            //标准的插入操作，和父结点用红链接相连
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if(cmp < 0){
            h.left = put(h.left, key, val);
        }else if(cmp > 0){
            h.right = put(h.right, key, val);
        }else{
            h.val = val;
        }

        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
}
