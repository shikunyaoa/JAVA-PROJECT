package com.kunyao.java.function;

import java.util.stream.Stream;

/**
 * @ClassName: function_reduce
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 13:18
 * @Version: 1.0
 */
public class function_reduce {
    public static void main(String[] args) {
        //而Stream.reduce()则是Stream的一个聚合方法，它可以把一个Stream的所有元素按照聚合函数聚合成一个结果。
        //reduce()方法传入的对象是BinaryOperator接口，它定义了一个apply()方法，负责把上次累加的结果和本次的元素 进行运算，并返回累加的结果
        //0是初始化结果
        //acc表示上次累加的结果
        //n表示本次的元素
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45


    }
}
