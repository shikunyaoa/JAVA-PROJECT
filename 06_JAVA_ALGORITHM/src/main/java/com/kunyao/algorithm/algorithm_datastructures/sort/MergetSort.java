package com.kunyao.algorithm.algorithm_datastructures.sort;

/**
 * @ClassName: MergetSort
 * @Author: kunyao
 * @Description: 归并排序： 分而治之的思想
 * @Date: 2020/6/15 20:27
 * @Version: 1.0
 */
public class MergetSort {

    public static void main(String[] args) {

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = ( left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1,right, temp);
            merge(arr, left, mid , right, temp);
        }
    }

    /**
     *
     * @param arr 排序数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){

        int i = left; //左边的起始索引
        int j = mid + 1; //右边的起始索引
        int t = 0;

        while(j <= mid && i <= right){

            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else{
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }

        }

        while(i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while(j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            temp[t] = arr[tempLeft];
            t += 1;
            tempLeft += 1;
        }
    }
}
