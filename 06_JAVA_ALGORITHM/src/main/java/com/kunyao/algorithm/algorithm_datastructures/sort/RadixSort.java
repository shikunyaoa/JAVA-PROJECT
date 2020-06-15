package com.kunyao.algorithm.algorithm_datastructures.sort;

/**
 * @ClassName: RadixSort
 * @Author: kunyao
 * @Description: 基数排序（桶排序）：分为10个桶，依次根据个位，十位，百位，分别放入桶中，最后一轮即为有序
 * @Date: 2020/6/15 21:14
 * @Version: 1.0
 */
public class RadixSort {

    public static void main(String[] args) {

    }


    public static void radixSort(int[] arr){


        int max = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength ; i++, n *= 10) {
            //二维数组
            int[][] bucket = new int[10][arr.length];

            //存放每个对应的桶存放的元素的个数值
            int[] bucketElementCounts = new int[10];

            for (int f = 0; f < arr.length; f++) {
                int digitOfElement = arr[f] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[f];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if(bucketElementCounts[k] != 0){
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }

                bucketElementCounts[k] = 0;
            }
        }



    }
}
