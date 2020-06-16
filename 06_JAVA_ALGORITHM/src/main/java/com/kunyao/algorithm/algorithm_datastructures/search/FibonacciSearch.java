package com.kunyao.algorithm.algorithm_datastructures.search;

import java.util.Arrays;

/**
 * @ClassName: FibonacciSearch
 * @Author: kunyao
 * @Description: 斐波那契查找(黄金分割查找)
 * @Date: 2020/6/16 20:55
 * @Version: 1.0
 */
public class FibonacciSearch {

    public static int MAXSIZE = 20;

    public static void main(String[] args) {

    }

    public static int[] fib(){
        int[] f = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAXSIZE - 1 ; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }


    public static int fibonacciSearch(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int[] f = fib();

        //获取斐波那契分割数值的下标
        while(high > f[k - 1]){
            k++;
        }

        //因为f[k]值可能大于a长度
        int[] temp = Arrays.copyOf(arr, f[k]);

        //使用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length ; i++) {
            temp[i] = arr[high];
        }

        while(low <= high){
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]){
                high = mid - 1;
                k--;
            }else if(key > temp[mid]){
                low = mid + 1;
                k-=2;
            }else{
                if(mid <= high){
                    return mid;
                }else{
                    return high;
                }
            }
        }

        return -1;
    }
}
