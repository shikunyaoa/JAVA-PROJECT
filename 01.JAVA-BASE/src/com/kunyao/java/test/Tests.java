package com.kunyao.java.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: Tests
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/31 11:24
 * @Version: 1.0
 */

public class Tests {
    Calculator calculator;

    // @BeforeEach初始化
    @BeforeEach
    public void setup(){
        this.calculator = new Calculator();
    }
    //@AfterEach 清理资源
    @AfterEach
    public void tearDown(){
        this.calculator = null;
    }

    //@EnableOnOs就是一个条件测试判断,只能在WINDOWS中运行
    //@DisabledOnOs

    //@DisabledOnJre(JRE.JAVA_8)
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testAdd() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150, this.calculator.add(50));
        assertEquals(130, this.calculator.add(-20));
    }

    @Test
    void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));
    }
}


class Calculator{
    private long n = 0;

    public long add(long x){
        n = n + x;
        return n;
    }

    public long sub(long x){
        n = n - x;
        return n;
    }
}