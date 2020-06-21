package com.kunyao.algorithm.algorithm_datastructures.huffmanCode;

import javax.swing.undo.CannotUndoException;
import java.util.*;

/**
 * @ClassName: HuffmanCode
 * @Author: kunyao
 * @Description: 哈夫曼编码：压缩数据
 * @Date: 2020/6/21 11:32
 * @Version: 1.0
 */
public class HuffmanCode {

    public static void main(String[] args) {

        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);

        System.out.println("赫夫曼树");
        Node haffManTreeRoot = createHuffmanTree(nodes);
        System.out.println(haffManTreeRoot);

        getCode(haffManTreeRoot, "", stringBuilder );
    }

    /**
     * 生成h赫夫曼树对应的赫夫曼编码
     *
     * 1. 将赫夫曼编码表存放在Map<Byte, String>形式
     * 2. 在生成赫夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
     */

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();


    /**
     * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes中
     * @param node 传入节点
     * @param code 路径：左子节点是0 ， 右子节点是1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCode(Node node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);

        //将code加入到stirngBuilder1
        stringBuilder1.append(code);

        if(node != null){

            //判断当前node是叶子节点，还是非叶子节点
            if(node.data == null){ //非叶子节点
                //递归处理
                //向左递归
                getCode(node.left, "0", stringBuilder1);
                //向右递归
                getCode(node.right, "1", stringBuilder1);
            }else{
                //表示是要给叶子节点，就表示找到底部的叶子节点
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }

    }

    /**
     * 前序遍历
     */
    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("赫夫曼树不能为空");
        }
    }

    /**
     * 将字节数组转化为Node的集合
     * @param bytes 接受字节数组
     * @return
     */
    private static List<Node> getNodes(byte[] bytes){

        //1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes,统计每个byte出现的次数 ->map
        Map<Byte, Integer> counts = new HashMap<>();
        for(byte b: bytes){
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b, 1);
            }else{
                counts.put(b, count + 1);
            }

        }

        //把每个键值对转化为一个Node对象，并加入到nodes集合
        for(Map.Entry<Byte, Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }


    /**
     * 通过List创建对应的哈夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes){

        while(nodes.size() > 1){
            //排序，从小到大
            Collections.sort(nodes);
            //取出一棵最小的二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一个新的二叉树，它的根节点 没有data,只有权值
            Node parent = new Node(null, leftNode.getWeigth() + rightNode.getWeigth());
            parent.left = leftNode;
            parent.right = rightNode;

            //将两个二叉树移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将新的二叉树加入到nodes
            nodes.add(parent);
        }

        //最终nodes中只剩下一个节点，就是赫夫曼树的根节点
        return nodes.get(0);
    }
}

//创建Node， 待数据和权值
class Node implements Comparable<Node>{

    Byte data; //存放数据本身， 'a' => 97
    int weigth; //权值
    Node left;
    Node right;

    public Node(Byte data, int weigth) {
        this.data = data;
        this.weigth = weigth;
    }


    @Override
    public int compareTo(Node o) {
        return this.weigth - o.weigth;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weigth=" + weigth +
                '}';
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

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
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
}
