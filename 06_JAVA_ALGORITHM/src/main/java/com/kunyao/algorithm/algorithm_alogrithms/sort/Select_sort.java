package com.kunyao.algorithm.algorithm_alogrithms.sort;

/**
 * @ClassName: Select_sort
 * @Author: kunyao
 * @Description: 选择排序 - 选择数组中最小的元素放到数组的最左边，直到数组有序
 * @Date: 2020/7/29 14:08
 * @Version: 1.0
 */
public class Select_sort {

    public static void sort(Comparable[] a){
        int N  = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i, min);
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
