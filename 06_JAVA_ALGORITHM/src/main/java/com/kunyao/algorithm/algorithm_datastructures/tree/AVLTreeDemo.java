package com.kunyao.algorithm.algorithm_datastructures.tree;

/**
 * @ClassName: AVLTreeDemo
 * @Author: kunyao
 * @Description: AVL树（平衡二叉树）
 * @Date: 2020/6/24 19:36
 * @Version: 1.0
 */
public class AVLTreeDemo {

}

class AVlTree{

    private AvlNode root;

    public AvlNode getRoot(){
        return root;
    }

    public AvlNode search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }

    }


    public AvlNode searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searcParent(value);
        }
    }

    /**
     * 删除node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    public int delRightTreeMin(AvlNode node){
        AvlNode target = node;
        //循环的查找左子节点，就会找到最小值
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
            AvlNode targetNode = search(value);
            if(targetNode == null){
                return ;
            }
            //只有一个根节点且查找到的就是根节点
            if(root.left == null && root.right == null){
                root = null;
                return ;
            }

            AvlNode parent = searchParent(value);
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

    public void add(AvlNode node){
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

class AvlNode{

    int value;
    AvlNode left;
    AvlNode right;

    public AvlNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AvlNode{" +
                "value=" + value +
                '}';
    }


    /**
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if(left == null){
            return 0;
        }else{
            return left.height();
        }

    }


    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if(right == null){
            return 0;
        }else{
            return right.height();
        }
    }

    /**
     * 返回以当前节点为根节点的高度
     * @return
     */
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 查找要删除的节点
     * @param value
     * @return
     */
    public AvlNode search(int value){
        if(value == this.value){
            return this;
        }else if(value < this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }


    /**
     * 查找要删除节点的父节点
     * @param value
     * @return
     */
    public AvlNode searcParent(int value){

        //如果当前节点就是要删除节点的父节点，就返回
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else{
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if(value < this.value && this.left != null){
                return this.left.searcParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searcParent(value);
            }else{
                //没有找到父节点
                return null;
            }
        }
    }

    //添加节点的方法
    public void add(AvlNode node){
        if(node == null){
            return;
        }

        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }

        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
}