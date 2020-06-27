package com.kunyao.algorithm.algorithm_datastructures.divide_and_Conquer;

/**
 * @ClassName: Hanoitower
 * @Author: kunyao
 * @Description: 汉诺塔移动方法 - 分治算法
 * @Date: 2020/6/27 10:43
 * @Version: 1.0
 */
public class Hanoitower {

    public static void main(String[] args) {

        hanoitower(3, 'A', 'B', 'C');
    }

    /**
     * 纳诺塔移动问题
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoitower(int num, char a, char b, char c){

        //如果只有一个盘
        if(num == 1){
            System.out.println("第一个盘从" + a + "->" + c);
        }else{
            //如果num >= 2 ,总是可以看做两个盘，1.最下面的一个盘  2.上面的所有盘
            //1， 先把最上面的所有盘 A->B ,移动过程会使用到C
            hanoitower(num - 1, a, c, b);
            //2， 把最下面的盘移动到C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3. 把B塔的所有盘从B->C ,移动过程使用a塔
            hanoitower(num - 1, b, a, c);
        }
    }
}
