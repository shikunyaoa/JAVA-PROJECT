package com.kunyao.algorithm.algorithm_datastructures.kmp;

/**
 * @ClassName: KMPAlgorithm
 * @Author: kunyao
 * @Description: KMP算法解决字符串匹配问题
 * @Date: 2020/6/27 19:50
 * @Version: 1.0
 */
public class KMPAlgorithm {

    public static void main(String[] args) {

    }

    /**
     * kmp搜索算法
     * @param str1 原字符串
     * @param str2  子串
     * @param next 部分匹配表，是字串对应的部分匹配表
     * @return  如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next){

        for (int i = 0, j = 0; i < str1.length() ; i++) {

            //kmp算法核心
            //需要处理str1.charAt(i) != str2.charAt(j)，调整j的大小
            while( j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            
            if(j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 获取一个字符串的部分匹配值表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest){
        //创建一个next数组保存匹配值
        int[] next = new int[dest.length()];
        //如果字符串是长度为1，部分匹配值就是0
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length() ; i++) {

            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            //当dest.charAt(i) == dest.charAt(j)满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}
