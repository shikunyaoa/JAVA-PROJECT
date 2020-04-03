package com.kunyao.java.design_patterns.prototype;

/**
 * @ClassName: prototype
 * @Author: kunyao
 * @Description: 原型设计模式
 * @Date: 2020/4/3 14:18
 * @Version: 1.0
 */
public class prototype {

    private int id;

    private String username;

    private int score;

    public prototype copy() {
        prototype prototype = new prototype();
        prototype.id = this.id;
        prototype.username = this.username;
        prototype.score = this.score;
        return prototype;
    }
}
