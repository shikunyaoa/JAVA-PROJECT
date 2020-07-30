package com.kunyao.algorithm.algorithm_alogrithms.search;

import org.omg.CORBA.Object;

/**
 * @ClassName: BinarySearch
 * @Author: kunyao
 * @Description: 二分查找算法
 * @Date: 2020/7/30 16:39
 * @Version: 1.0
 */
public class BinarySearch<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearch(int capcity) {
        keys = (Key[]) new Comparable[capcity];
        values = (Value[]) new Object[capcity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int rank(Key key){
        int lo = 0, hi = N - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0){
                hi = mid - 1;
            }else if(cmp > 0){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return lo;
    }

    public Value get(Key key){
        if(isEmpty()){
            return null;
        }

        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return values[i];
        }else{
            return null;
        }
    }
}
