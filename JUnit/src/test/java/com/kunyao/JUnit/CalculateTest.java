package com.kunyao.JUnit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 创建测试用例的快捷键是：ctrl + shift + t
 */
public class CalculateTest {

    Calculate calculate = new Calculate();
    int sum = calculate.sum(2, 5);
    int testSum = 7;
    @Test
    public void sum() {
        System.out.println("@Test sum():" + sum + "=" + testSum);
        assertEquals(sum, testSum);
    }
}

/**
 * 在IDEA2019.3中的输出结果是:
 * =======================
 * 相加的值是:2+5
 * @Test sum():7=7
 * =======================
 * 结论：没得问题，OJBK
 * */