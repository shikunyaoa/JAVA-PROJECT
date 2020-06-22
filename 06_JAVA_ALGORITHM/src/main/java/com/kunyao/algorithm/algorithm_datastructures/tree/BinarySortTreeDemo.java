package com.kunyao.algorithm.algorithm_datastructures.tree;

/**
 * @ClassName: BinarySortTree
 * @Author: kunyao
 * @Description: 二叉排序树
 * @Date: 2020/6/22 22:57
 * @Version: 1.0
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length ; i++) {
            binarySortTree.add(new TreeNode(arr[i]));
        }

        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{

    private TreeNode root;

    public void add(TreeNode node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }else{
            System.out.println("树不能为空");
        }
    }
}

class TreeNode{

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }


    //添加节点的方法
    public void add(TreeNode node){
        if(node == null){
            return;
        }

        //判断传入节点的值和当前子树的根节点的值的关系
        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else{
                //递归的向左子树添加
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
