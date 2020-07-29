package com.kunyao.algorithm.algorithm_alogrithms.sort;

/**
 * @ClassName: Insert_sort
 * @Author: kunyao
 * @Description: 插入排序 - 将数组的最左边当成一个有序表，将剩下的元素按顺序插入到有序表中合适的位置
 * @Date: 2020/7/29 14:53
 * @Version: 1.0
 */
public class Insert_sort {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N ; i++) {
            for(int j = i; i > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }



    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length ; i++) {
            if(less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
