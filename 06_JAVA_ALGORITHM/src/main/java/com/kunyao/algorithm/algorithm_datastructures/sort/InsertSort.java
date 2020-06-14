package com.kunyao.algorithm.algorithm_datastructures.sort;

/**
 * @ClassName: InsertSort
 * @Author: kunyao
 * @Description: 插入排序:分为有序表和无序表，默认第一个元素为有序表，然后依次将元素按特定的顺序插入到有序表中
 * @Date: 2020/6/14 16:08
 * @Version: 1.0
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1};
        InsertSort(arr);

    }

    public static void InsertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            //待插入的元素
            int insertVal = arr[i];
            //待插入的位置
            int insertIndex = i - 1;

            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }

        }
    }
}
