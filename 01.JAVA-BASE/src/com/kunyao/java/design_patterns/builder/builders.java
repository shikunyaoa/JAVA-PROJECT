package com.kunyao.java.design_patterns.builder;

/**
 * @ClassName: builders
 * @Author: kunyao
 * @Description: 生成器模式
 * @Date: 2020/4/3 14:13
 * @Version: 1.0
 */

/**
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 生成器模式（Builder）是使用多个“小型”工厂来最终创建出一个完整对象。
 *
 * 当我们使用Builder的时候，一般来说，是因为创建这个对象的步骤比较多，每个步骤都需要一个零部件，最终组合成一个完整的对象
 */
public class builders {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        builder.append("https://")
                .append("www.baidu.com")
                .append("/")
                .append("?t=0");
        String url = builder.toString();
        System.out.println(url);
    }
}
