package com.kunyao.algorithm.algorithm_01;

/**
 * @ClassName: BinarySearch
 * @Author: kunyao
 * @Description: 二分查找法
 * @Date: 2020/6/3 13:33
 * @Version: 1.0
 */
public class BinarySearch {

    private static final int NOT_FOUND = -1;

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x){

        int low = 0, high = a.length - 1;

        while(low < high){

            int mid = (low + high) / 2;
            if(a[mid].compareTo(x) < 0){
                low = mid + 1;
            }else if(a[mid].compareTo(x) > 0){
                high = mid - 1;
            }else{
                return mid;
            }
        }

        return NOT_FOUND;
    }
}
