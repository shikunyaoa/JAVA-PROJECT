package com.kunyao.algorithm.algorithm_datastructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BinarySearch
 * @Author: kunyao
 * @Description: 二分查找法
 * @Date: 2020/6/16 19:05
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1,8, 10, 89, 1000, 1000, 1234};
        List<Integer> index = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal){

        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal){
            return binarySearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            return binarySearch(arr, left, mid - 1, findVal);
        }else{
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){

        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal){
            return binarySearch2(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){
            return binarySearch2(arr, left, mid - 1, findVal);
        }else{
            List<Integer> lists = new ArrayList<Integer>();

            int temp = mid - 1;
            while(temp > 0){
                if(arr[temp] == findVal){
                    lists.add(temp);
                }
                temp -= 1;
            }

            lists.add(mid);

            temp = mid + 1;
            while(temp < (arr.length - 1)){
                if(arr[temp] == findVal){
                    lists.add(temp);
                }
                temp += 1;
            }


            return lists;
        }
    }
}
