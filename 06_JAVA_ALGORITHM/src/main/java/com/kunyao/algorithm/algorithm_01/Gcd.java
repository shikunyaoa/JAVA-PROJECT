package com.kunyao.algorithm.algorithm_01;

/**
 * @ClassName: Gcd
 * @Author: kunyao
 * @Description: 欧几里得算法
 * @Date: 2020/6/3 13:44
 * @Version: 1.0
 */
public class Gcd {

    public static long gcd(long m, long n){

        while(n != 0){
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        long m = gcd(1989, 1590);
        System.out.println(m);
    }
}
