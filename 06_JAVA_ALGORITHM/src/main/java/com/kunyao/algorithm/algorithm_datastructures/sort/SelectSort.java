package com.kunyao.algorithm.algorithm_datastructures.sort;

import java.util.Arrays;

/**
 * @ClassName: SelectSort
 * @Author: kunyao
 * @Description: 选择排序：假定一个元素为最小元素，然后与其他元素进行比较，然后进行互换位置
 * @Date: 2020/6/14 12:03
 * @Version: 1.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void selectSort(int[] arr){


        //外层循环控制循环次数
        for (int i = 0; i < arr.length - 1 ; i++) {
            //假定最小值的下标
            int minIndex = i;
            //假定数组中最小值
            int min = arr[i];
            //将假定最小值与其他元素进行比较，找到真正的最小值
            for (int j = i + 1; j < arr.length ; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
