package com.kunyao.algorithm.algorithm_datastructures.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: HuffmanTree
 * @Author: kunyao
 * @Description: 哈夫曼树
 * @Date: 2020/6/20 19:23
 * @Version: 1.0
 */
public class HuffmanTree {


    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);

        preOrder(huffmanTree);
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }
    }

    /**
     * 创建赫夫曼树
     * @param arr
     * @return
     */
    public static Node createHuffmanTree(int[] arr){

        List<Node> list = new ArrayList<>();

        for(int value : arr){
            list.add(new Node(value));
        }
        while(list.size() > 1){
            Collections.sort(list);

            Node left = list.get(0);

            Node right = list.get(1);

            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;


            list.remove(left);
            list.remove(right);

            list.add(parent);

            Collections.sort(list);

            System.out.println(list);

        }


        return list.get(0);
    }

}


class Node implements Comparable<Node>{

    int value;

    //左子节点
    Node left;

    //右子节点
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
