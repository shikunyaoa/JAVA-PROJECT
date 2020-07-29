package com.kunyao.algorithm.algorithm_datastructures.sort;

/**
 * @ClassName: HeapSort
 * @Author: kunyao
 * @Description: 堆排序：基于树实现
 * @Date: 2020/6/20 11:01
 * @Version: 1.0
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};
    }


    /**
     *
     * @param arr
     */
    public static void heapSort(int[] arr){

        int temp = 0;
        //i = arr.length / 2 - 1 表示找到非叶子节点
        //将无序序列构建成一个堆
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i , arr.length);
        }


        //将最大值与最后一个数进行置换，并循环对剩下的数进行调整
        for (int j = arr.length - 1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * 将一个数组（二叉树），调整为一个大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length){

        //先取出当前元素的值，保存在临时变量
        int temp = arr[i];

        //k = i * 2 + 1 k是i节点的左子节点
        for (int k = i * 2 + 1 ; k < length ; k = k * 2 + 1) {

            //arr[k] < arr[k+1] 说明左子节点的值小于右子节点
            if(k+1 < length && arr[k] < arr[k+1]){
                k++; //k指向右子节点
            }

            //如果子节点大于父节点
            if(arr[k] > temp){
                //把较大的值赋给当前节点
                arr[i] = arr[k];
                //i指向k, 继续循环比较
                i = k;
            }else{
                break;
            }
        }

        //将temp值放到调整后的位置
        arr[i] = temp;
    }
}
