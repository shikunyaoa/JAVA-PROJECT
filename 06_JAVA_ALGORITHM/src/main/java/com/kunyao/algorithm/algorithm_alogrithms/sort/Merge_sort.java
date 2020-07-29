package com.kunyao.algorithm.algorithm_alogrithms.sort;

/**
 * @ClassName: Insert_sort
 * @Author: kunyao
 * @Description: 归并排序 - 将数组拆成小数组进行排序，然后将结果归并起来，需要额外的空间
 * @Date: 2020/7/29 14:53
 * @Version: 1.0
 */
public class Merge_sort {

    private static Comparable[] aux; //归并所需的辅助数组

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    //自顶向下归并排序
    public static void sort(Comparable[] a, int lo, int hi){
       //将数组a[lo...hi]排序
        if(hi <= lo){
            return ;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); //将左半边排序
        sort(a, mid + 1, hi); //将右半边排序
        merge(a, lo, mid, hi);
    }

    //自底向上归并排序
    public static void sort2(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N ; sz = sz + sz) {  //sz子数组大小
            for (int lo = 0; lo < N - sz ; lo += sz + sz) { //lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        //将a[lo...mid]和a[mid+1...hi]归并
        int i = lo, j = mid + 1;

        //将a[lo...hi]复制到aux[lo...hi]
        for (int k = lo; k <= hi ; k++) {
            aux[k] = a[k];
        }

        //归并回到a[lo...hi]
        for (int k = lo; k <= hi ; k++) {

            if(i > mid){              //左边用尽，取右边的元素
                a[k] = aux[j++];
            }else if(j > hi){         //右边用尽，取左边的元素
                a[k] = aux[i++];
            }else if(less(aux[j], aux[i])){ //右半边的元素小于左半边的元素，取右边的元素
                a[k] = aux[j++];
            }else{                          //右半边的元素大于左半边的元素，取左边的元素
                a[k] = aux[i++];
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
