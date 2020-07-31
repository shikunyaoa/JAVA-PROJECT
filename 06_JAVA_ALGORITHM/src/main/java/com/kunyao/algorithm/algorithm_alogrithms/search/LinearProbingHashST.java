package com.kunyao.algorithm.algorithm_alogrithms.search;

import org.omg.CORBA.Object;

/**
 * @ClassName: LinearProbingHashST
 * @Author: kunyao
 * @Description: 基于线性探测的符号表
 * @Date: 2020/7/31 17:05
 * @Version: 1.0
 */
public class LinearProbingHashST<Key, Value> {

    private int N; //符号表中键值对的总数
    private int M = 16; //线性探测表的大小
    private Key[] keys; //键
    private Value[] vals; //值
    public LinearProbingHashST(int cap){
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(){
        resize(10);
    }

    private void resize(int cap){
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M ; i++) {
            if(keys[i] != null){
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val){
        if(N >= M / 2){
            resize();
        }
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key){
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }

    public boolean constains(Key key){
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    public void delete(Key key){
        if(!constains(key)){
            return;
        }
        int i = hash(key);

        while(!key.equals(keys[i])){
            i = (i + 1) % M;
        }

        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while(keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if(N > 0 && N == M / 8){
            resize();
        }
    }
}
