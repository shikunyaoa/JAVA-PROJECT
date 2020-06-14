package com.kunyao.algorithm.algorithm_datastructures.sort;

import java.util.Arrays;

/**
 * @ClassName: SelectSort
 * @Author: kunyao
 * @Description: 选择排序
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


        for (int i = 0; i < arr.length - 1 ; i++) {
            int minIndex = i;
            int min = arr[i];
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
