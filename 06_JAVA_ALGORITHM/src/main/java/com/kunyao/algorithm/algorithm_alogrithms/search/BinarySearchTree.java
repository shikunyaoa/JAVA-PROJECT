package com.kunyao.algorithm.algorithm_alogrithms.search;


import sun.misc.Queue;

/**
 * @ClassName: BinarySearchTree
 * @Author: kunyao
 * @Description: 二叉查找树
 * @Date: 2020/7/30 16:59
 * @Version: 1.0
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;  //二叉查找树的根节点

    private class Node{
        private Key key;        //键
        private Value value;    //值
        private Node left,right; //指向子树的连接
        private int N;          //以该节点为根的子树中的节点总数

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
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

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return get(x.left, key);
        }else if(cmp > 0){
            return get(x.right, key);
        }else{
            return x.value;
        }
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x == null){
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, val);
        }else if(cmp > 0){
            x.right = put(x.right, key, val);
        }else{
            x.value = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }

    private Node select(Node x, int k){
        if(x == null){
            return null;
        }
        int t = size(x.left);
        if(t > k){
            return select(x.left, k);
        }else if(t < k){
            return select(x.right, k - t - 1);
        }else{
            return x;
        }
    }


    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left, key);
        }else if(cmp > 0){
            x.right = delete(x.right, key);
        }else{
            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }

            Node t = x;
            //将当前节点右子树中最小的节点替换掉当前节点
            x = min(t.right);
            //将替换后节点的右节点设置为删除替换节点后的父节点
            //被删除节点的右节点会成为替换节点父节点的左节点
            x.right = deleteMin(t.right);
            //将替换后节点的左节点设置为原节点的左节点
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null){
            return x;
        }
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null){
            return x;
        }
        return max(x.right);
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
//        return queue;
        return null;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if(x == null){
            return;
        }

        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if(cmplo < 0){
            keys(x.left, queue, lo, hi);
        }
        if(cmplo <= 0 && cmphi >= 0){
            queue.enqueue(x.key);
        }

        if(cmphi > 0){
            keys(x.right, queue, lo, hi);
        }
    }
}
