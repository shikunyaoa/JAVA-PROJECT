package com.kunyao.algorithm.algorithm_datastructures.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Author: kunyao
 * @Description: 快速排序：设定一个元素，将小于该元素的放在左边，大于该元素的放在右边；
 * @Date: 2020/6/15 19:12
 * @Version: 1.0
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right){

        //左下标
        int l = left;
        //右下标
        int r = right;

        int pivot = arr[(left + right) / 2];
        int temp = 0;

        //比pivot的值小的放在左边
        //比pivot的值大的放在右边
        while(l < r){

            //找到左边比pivot大的下标
            while(arr[l] < pivot){
                l += 1;
            }

            //找到右边比pivot小的下标
            while(arr[r] > pivot){
                r -= 1;
            }

            //当l == r 即 l == r == pivot时退出
            if(l >= r){
                break;
            }

            //将找到的两个元素进行交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;


            if(arr[l] == pivot){
                r -= 1;
            }

            if(arr[r] == pivot){
                l += 1;
            }
        }

        if(l == r){
            l += 1;
            r -= 1;
        }

        if(left < r){
            quickSort(arr, left, r);
        }

        if(right > l){
            quickSort(arr, l, right);
        }
    }
}
