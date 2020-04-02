package com.kunyao.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: regexs
 * @Author: kunyao
 * @Description: 正则表达式
 * @Date: 2020/4/2 14:58
 * @Version: 1.0
 */
public class regexs {
    private static Pattern PATTERN_NUMBER = Pattern.compile("(\\d+)(0*)");
    private static Pattern PATTERN_NUMBERS = Pattern.compile("(\\d+?)(0*)");
    public static void main(String[] args) {

        String regex = "20\\d\\d";
        //Java字符串用\\表示\
        // \d表示任意一个数字 \D匹配一个非数字
        System.out.println("2019".matches(regex)); //true

        // .可以匹配任意一个字符且仅限一个字符

        //\w可以匹配任意一个字母，数字和下划线 \W可以匹配\w不能匹配的字符

        //\t可以匹配一个空格字符

        //\s可以匹配一个空格字符 \S可以匹配\s不能匹配的字符

        //\d*  *可以匹配任意的数字
        //\d+  +至少匹配一个字符
        //\d?  ?匹配0个或一个字符
        //\d{n} n指定匹配多少个



        //匹配开头和结尾
        // ^表示开头  $表示结尾
        //匹配指定范围 [...]   [123456789] [0-9a-fA-F]{6}

        //[^1-9]{3} [^...]表示不包含某些字符


        //AB|CD 表示匹配AB或CD
        String re = "java|php";
        System.out.println("java".matches(re)); //true
        System.out.println("python".matches(re)); //false

        //用括号将子规则包括起来
        String res = "learn\\s(java|php|go)";
        System.out.println("learn java".matches(re)); //true


        //正则表达式默认使用贪婪匹配：任何一个规则，它总是尽可能多地向后匹配
        Matcher matcher = PATTERN_NUMBER.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); //group1=1230000
            System.out.println("group2=" + matcher.group(2)); //group2=
        }

        //使用非贪婪匹配,在规则\d+后面加个?即可表示非贪婪匹配
        Matcher matchers = PATTERN_NUMBERS.matcher("1230000");
        if (matchers.matches()) {
            System.out.println("group1=" + matchers.group(1)); //group1=123
            System.out.println("group2=" + matchers.group(2)); //group2=0000
        }
    }
}
