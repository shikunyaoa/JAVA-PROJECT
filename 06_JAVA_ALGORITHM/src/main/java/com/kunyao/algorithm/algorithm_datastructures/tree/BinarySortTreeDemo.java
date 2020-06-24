package com.kunyao.algorithm.algorithm_datastructures.tree;

/**
 * @ClassName: BinarySortTree
 * @Author: kunyao
 * @Description: 二叉排序树：
 * 对于树中的每个节点X，它的左子树中所有项的值小于X中的值，而
 * 它的右子树中的所有项的值大于X中的项
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


    public TreeNode search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }
    }


    public TreeNode searchParent(int value){
        if(root == null){
            return null;
        }else{
            return this.searchParent(value);
        }
    }

    /**
     * 返回的以node为根节点的二叉排序树的最小节点的值
     * 删除node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    public int delRightTreeMin(TreeNode node){
        TreeNode target = node;

        while(target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if(root == null){
            return ;
        }else{
            TreeNode targetNode = search(value);
            if(targetNode == null){
                return ;
            }
            //只有一个根节点且查找到的就是根节点
            if(root.left == null && root.right == null){
                root = null;
                return ;
            }


            TreeNode parent = searchParent(value);

            //如果要删除的节点是叶子节点
            if(targetNode.left == null && targetNode.right == null){
                //判断targetNode是父节点的左子节点还是右子节点
                if(parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if(parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if(targetNode.left != null && targetNode.right != null){
                //有两个子树
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else{
                //有一个子树
                if(targetNode.left != null){
                    //判断targetNode是parent的左子节点还是右子节点
                    if(parent != null){
                        if(parent.left.value == value){
                            parent.left = targetNode.left;
                        }else{
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }

                }else{
                    //如果要删除的节点有右子节点
                    if(parent != null){
                        if(parent.left.value == value){
                            parent.left = targetNode.right;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }

                }
            }
        }
    }

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

    public TreeNode search(int value){
        if(this.value == value){
            return this;
        }

        if(this.value > value){
            if(this.left != null){
                return this.left.search(value);
            }
        }else{
            if(this.right != null){
                return this.right.search(value);
            }
        }
        return null;
    }

    public TreeNode searchParent(int value){

        if(this.value == value){
            return this;
        }

        if(this.value > value){
            if(this.left != null && this.left.value == value){
                return this;
            }else{
                return this.left.searchParent(value);
            }
        }else{
            if(this.right != null && this.right.value == value){
                return this;
            }else{
                return this.right.searchParent(value);
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
