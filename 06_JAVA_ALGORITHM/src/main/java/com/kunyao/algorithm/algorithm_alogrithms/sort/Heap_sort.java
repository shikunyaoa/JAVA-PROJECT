package com.kunyao.algorithm.algorithm_alogrithms.sort;

/**
 * @ClassName: Heap_sort
 * @Author: kunyao
 * @Description: 堆排序 - 是一组能够用堆有序的完全二叉树排序的元素，并在数组中按照层级存储（不使用数组的第一个位置）
 * @Date: 2020/7/30 13:50
 * @Version: 1.0
 */
public class Heap_sort<Key extends Comparable<Key>> {

    private Key[] pq;  //基于堆的完全二叉树
    private int N = 0; //存储于pq[1..N]中，pq[0]没有使用

    public Heap_sort(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }
    
    public void sort(Comparable[] a){
        int N = a.length;
        for (int k = N / 2; k >= 1 ; k--) {
            sink(k);
        }

        while(N >1){
            exch(1, N--);
            sink(N);
        }
    }
    
    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1]; //从根节点得到最大元素
        exch(1, N--); //将其和最后一个节点交换
        pq[N+1] = null; //防止越界
        sink(1);    //恢复堆的有序性
        return max;
    }

    /**
     * 由下至上的堆有序化（上浮）
     * @param k
     */
    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }


    /**
     * 由上至下的堆有序化（下沉）
     * @param k
     */
    private void sink(int k){
        while(2*k <= N){
            int j = 2 * k;
            if(j < N && less(j, j+1)){
                j++;
            }
            if(!less(k, j)){
                break;
            }
            exch(k, j);
            k = j;

        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
