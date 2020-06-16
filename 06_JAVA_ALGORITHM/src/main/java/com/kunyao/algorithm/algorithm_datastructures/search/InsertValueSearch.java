package com.kunyao.algorithm.algorithm_datastructures.search;

/**
 * @ClassName: InsertValueSearch
 * @Author: kunyao
 * @Description: 插值查找
 * @Date: 2020/6/16 20:20
 * @Version: 1.0
 */
public class InsertValueSearch {

    public static void main(String[] args) {


    }


    public static int insertValueSearch(int[] arr, int left, int right, int findVal){

        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if(findVal > midVal){
            return insertValueSearch(arr, mid + 1, right, findVal);
        }else if(findVal < midVal){
            return insertValueSearch(arr, left, mid - 1, findVal);
        }else{
            return mid;
        }
    }
}
