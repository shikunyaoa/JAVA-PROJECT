package com.kunyao.algorithm.algorithm_datastructures.sort;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Author: kunyao
 * @Description: 冒泡排序
 * @Date: 2020/6/14 10:56
 * @Version: 1.0
 */
public class BubbleSort {


    public static void main(String[] args) {

        int[] arr = {3, 9, -1, 10, -2};

        bubbleSort(arr);

        System.out.println("第一趟排序后");
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j ; i++) {
                if(arr[i] > arr[i + 1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
