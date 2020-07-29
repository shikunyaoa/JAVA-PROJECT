package com.kunyao.algorithm.algorithm_alogrithms.sort;

/**
 * @ClassName: Select_sort
 * @Author: kunyao
 * @Description: 希尔排序 - 基于插入排序，先将数组h范围内有序，直到整个数组有序
 * @Date: 2020/7/29 14:08
 * @Version: 1.0
 */
public class Shell_sort {

    public static void sort(Comparable[] a){
        int N  = a.length;
        int h = 1;
        while(h < N/3){
            h = 3*h + 1;
        }
        while(h >= 1){
            //将数组变为h有序
            for (int i = 0; i < N ; i++) {
                //将a[i]插入到a[i-h], a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
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
