package com.kunyao.algorithm.algorithm_datastructures.tree;

/**
 * @ClassName: BinarySearchTree
 * @Author: kunyao
 * @Description: 二叉查找树
 * @Date: 2020/6/10 14:15
 * @Version: 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T theElement){
            this(theElement, null, null);
        }

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }


    private BinaryNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 判断树中是否包含x节点
     * @param x
     * @return
     */
    public boolean contains(T x){

        return contains(x, root);
    }

    public T findMin(T x){
        if(isEmpty()){
            throw new RuntimeException();
        }
        return findMin(root).element;
    }

    public T findMax(T x){
        if(isEmpty()){
            throw new RuntimeException();
        }
        return findMax(root).element;
    }

    public void insert(T t){
        root = insert(t, root);
    }

    public void remove(T t){
        root = remove(t, root);
    }

    public void printTree(){

    }

    private boolean contains(T x, BinaryNode<T> root) {
        if(root == null){
            return false;
        }
        int compareReuslt = x.compareTo(root.element);
        if(compareReuslt < 0){
            return contains(x, root.left);
        }else if(compareReuslt > 0){
            return contains(x, root.right);
        }else{
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if(root == null){
            return null;
        }else if(root.left == null){
            return root;
        }

        return findMin(root.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> root){
        if(root != null){
            while(root.right != null){
                root = root.right;
            }
        }
        return root;
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> root){
        if(root == null){
            return new BinaryNode<>(t, null, null);
        }
        int compareResult = t.compareTo(root.element);

        if(compareResult < 0){
            root.left = insert(t, root.left);
        }else if(compareResult > 0){
            root.right = insert(t, root.right);
        }else{
            ;
        }
        return root;
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> root){
        if(root == null){
            return root;
        }

        int compareResult = t.compareTo(root.element);
        if(compareResult < 0){
            root.left = remove(t, root.left);
        }else if(compareResult > 0){
            root.right = remove(t, root.right);
        }else if(root.left != null && root.right != null){
            //如果有两个儿子
            //删除策略是：
            //用其右子树的最小的数据代替该节点的数据并递归的删除那个节点
            root.element = findMin(root.right).element;
            //将两个节点的转化为一个节点的删除
            root.right = remove(root.element, root.right);
        }else{
            //如果节点有一个儿子，则调整父节点的链进行删除
            root = (root.left != null) ? root.left : root.right;
        }

        return root;

    }
}
