package com.kunyao.algorithm.algorithm_datastructures.sort;

/**
 * @ClassName: ShellSort
 * @Author: kunyao
 * @Description: 希尔排序（缩小增量法）
 * @Date: 2020/6/14 16:58
 * @Version: 1.0
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,4,5,6,0};
    }


    /**
     * 交换法
     * @param arr
     */
    public static void ShellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i - gap; j >= 0 ; j-=gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }


    /**
     * 移位法
     * @param arr
     */
    public static void ShellSort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length ; i++) {
                int j = i;
                int temp = arr[i];
                if(arr[j] < arr[j - gap]){
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
