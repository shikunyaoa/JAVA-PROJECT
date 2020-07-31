package com.kunyao.algorithm.algorithm_alogrithms.search;

/**
 * @ClassName: SeparateChainingHashST
 * @Author: kunyao
 * @Description: 基于拉链法的散列表
 * @Date: 2020/7/31 16:31
 * @Version: 1.0
 */
public class SeparateChainingHashST<Key, Value> {

    private int N; //键值对总数
    private int M; //散列表的大小
    private SeparateChainingHashST<Key, Value>[] st; //存放链表对象的数组

    public SeparateChainingHashST(){
        this(997);
    }

    public SeparateChainingHashST(int M){
        //创建M条链表
        this.M = M;
        st = (SeparateChainingHashST<Key, Value>[])new SeparateChainingHashST[M];
        for (int i = 0; i < M ; i++) {
            st[i] = new SeparateChainingHashST();
        }
    }

    //采用除留余数法计算hash值
    private int hash(Key key){
        //key.hashCode() & 0x7fffffff 的作用是去掉符号位，
        return (key.hashCode() & 0x7fffffff % M);
    }

    public Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }

    public void put(Key key, Value val){
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys(){

        return null;
    }
}
