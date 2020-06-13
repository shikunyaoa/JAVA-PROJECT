package com.kunyao.algorithm.algorithm_datastructures.recursion;

/**
 * @ClassName: Queue8
 * @Author: kunyao
 * @Description: 八皇后回溯
 * @Date: 2020/6/13 16:47
 * @Version: 1.0
 */
public class Queue8 {


    int max = 8;
    //定义数组array，保存皇后放置位置的地址
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
    }

    private void check(int n){
        if(n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            //先把这个皇后n,放到该行的第1列
            array[n] = i;
            if(judge(n)){ //不冲突
                //接着放n+1个皇后
                check(n + 1);
            }

        }
    }

    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i] == array[n] 判断是否在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i]) 判断是否在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
