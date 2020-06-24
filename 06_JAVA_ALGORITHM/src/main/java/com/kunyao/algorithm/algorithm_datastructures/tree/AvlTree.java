package com.kunyao.algorithm.algorithm_datastructures.tree;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @ClassName: AvlTree
 * @Author: kunyao
 * @Description: AVL树：是其每个节点的左子树和右子树的高度最多差1的二叉查找树
 * @Date: 2020/6/24 17:16
 * @Version: 1.0
 */
public class AvlTree<T extends Comparable<? super T>> {


    private static class AvlNode<T>{

        T element;    //存储的元素值
        AvlNode<T> left;  //左节点
        AvlNode<T> right; //右节点
        int height; //高度,

        public AvlNode(T theElement){
            this(theElement, null, null);
        }

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }


    /**
     * return the height of node t, or -1 if null
     * @param t
     * @return
     */
    private int height(AvlNode<T> t){
        return t == null ? -1 : t.height;
    }


    /**
     * Internal method to insert into a subtree
     * @param x
     * @param t
     * @return
     */
    private AvlNode<T> insert(T x, AvlNode<T> t){
        if(t == null){
            return new AvlNode<T>(x, null, null);
        }

        int compaceResult = x.compareTo(t.element);

        if(compaceResult < 0){
            t.left = insert(x, t.left);
        }else if(compaceResult > 0){
            t.right = insert(x, t.right);
        }else{
            ;
        }
        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;



    /**
     * Assume t is either balanced or within one of being balanced
     * @param t
     * @return
     */
    private AvlNode<T> balance(AvlNode<T> t) {
        if(t == null){
            return t;
        }

        if(height(t.left) - height(t.right) > ALLOWED_IMBALANCE){
            if(height(t.left.left) >= height(t.left.right)){
                t = rotateWithLeftChild(t);
            }else{
                t = doubleWithLeftChild(t);
            }
        }else if(height(t.right) - height(t.left) > ALLOWED_IMBALANCE){
            if(height(t.right.right) >= height(t.right.left)){
                t = rotateWithRightChild(t);
            }else{
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left) , height(t.right)) + 1;
        return t;
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.left);
        return rotateWithRightChild(k3);
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.right), height(k2.left)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }


    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

}
