package com.kunyao.algorithm.algorithm_datastructures.huffmanCode;


import javax.security.auth.DestroyFailedException;
import javax.swing.undo.CannotUndoException;
import java.io.*;
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
     *
     * @param huffmanCodes 赫夫曼编码表
     * @param huffmanBytes 赫夫曼得到的字节数组
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes){

        //1. 先得到huffmanBytes对应的二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }

        Map<String, Byte> map = new HashMap<>();

        for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length() ;) {
            int count = 1; //小的计数器
            Byte b = null;
            boolean flag = true;
            while(flag){

                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if(b == null){
                    count++;
                }else{
                    flag = false;
                }
            }

            list.add(b);
            i += count; //i直接移动到count
        }

        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length ; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转成一个二进制的字符串
     * @param flag 标志着是否需要补高位
     * @param b 传入的byte
     * @return
     */
    private static String byteToBitString(boolean flag, byte b){

        int temp = b; //将b转成int,便于后面调用Integer的方法

        //如果是正数还存在补高位
        if(flag){
            temp |= 256; //按位与
        }

        //返回的是temp对应的二进制补码
        String str = Integer.toBinaryString(temp);

        if(flag){
            return str.substring(str.length() - 8);
        }else{
            return str;
        }
    }

    /**
     * 返回一个赫夫曼编码压缩后的byte[]
     * @param bytes 原始的字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){

        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }

        int len = (stringBuilder.length() + 7) / 8;

        //创建压缩后的byte数组
        byte[]  huffmanCodeBytes = new byte[len];
        int index = 0;
        for(int i = 0; i < stringBuilder.length(); i += 8){
            String strByte;
            if(i + 8 > stringBuilder.length()){  //不够8位
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i, i + 8);
            }

            //将strByte转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmanCodeBytes;
    }


    /**
     * 解压文件
     * @param srcFile
     * @param dstFile
     */
    public static void unzipFile(String srcFile, String dstFile){

        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(srcFile);

            ois = new ObjectInputStream(is);

            //读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();

            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            //解码,得到原始的字节数组
            byte[] bytes = decode(huffmanCodes, huffmanBytes);

            //将bytes写入到目标文件
            os = new FileOutputStream(dstFile);

            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                ois.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用赫夫曼对文件进行压缩
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(String srcFile, String dstFile){

        //创建文件的输入流
        FileInputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个和源文件一样大小的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);

            //获得文件的赫夫曼编码表

            //将字节数组转化为Node的集合
            List<Node> nodes = getNodes(b);

            //通过List创建对应的哈夫曼树
            Node huffmanTree = createHuffmanTree(nodes);

            //将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes中
            getCode(huffmanTree, "", stringBuilder );

            //返回一个赫夫曼编码压缩后的byte[]
            byte[] zip = zip(b, huffmanCodes);

            //创建文件的输出流，存放输出文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //将编码后的字节数组写入压缩文件
            oos.writeObject(zip);


            //将赫夫曼编码表写入压缩文件，为了以后恢复文件使用
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
