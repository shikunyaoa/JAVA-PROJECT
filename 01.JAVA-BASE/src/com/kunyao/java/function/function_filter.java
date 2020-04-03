package com.kunyao.java.function;

import java.util.stream.IntStream;

/**
 * @ClassName: function_filter
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 13:16
 * @Version: 1.0
 */
public class function_filter {

    public static void main(String[] args) {
        //所谓filter()操作，就是对一个Stream的所有元素一一进行测试，不满足条件的就被“滤掉”了，剩下的满足条件的元素就构成了一个新的Stream。
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
        /**
         * 1
         * 3
         * 5
         * 7
         * 9
         */
    }
}
