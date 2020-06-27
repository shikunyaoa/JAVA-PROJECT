package com.kunyao.algorithm.algorithm_datastructures.kmp;

/**
 * @ClassName: ViolenceMatch
 * @Author: kunyao
 * @Description: 字符串暴力匹配
 * @Date: 2020/6/27 19:14
 * @Version: 1.0
 */
public class ViolenceMatch {

    public static void main(String[] args) {

    }


    //暴力匹配算法实现
    public static int violenceMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        //i索引指向s1
        int i = 0;
        //j索引指向s2
        int j = 0;

        while(i < s1Len && j < s2Len){
            if(s1[i] == s2[j]){
                i++;
                j++;
            }else{
                //如果匹配失败，就将i回溯到s1上一个字符的下一个字符
                i = i - (j - 1);
                j = 0;
            }
        }

        //判断是否匹配成功
        if(j == s2Len){
            return i - j;
        }else{
            return -1;
        }


    }
}
