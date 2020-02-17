package com.kunyao.JUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @ClassName: ParameterTest
 * @Author: kunyao
 * @Description:  Junit参数化测试
 * @Date: 2020/2/17 16:35
 * @Version: 1.0
 */

/**
 * Parameterized 是一个在JUnit内的运行器将运行相同的测试用例组在不同的输入
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    private int expected;
    private int first;
    private int second;

    //构造函数，存储测试数据
    public ParameterTest(int expected, int first, int second) {
        this.expected = expected;
        this.first = first;
        this.second = second;
    }

    //静态方法生成并返回测试数据，并注明@Parameters注解
    @Parameterized.Parameters
    public static Collection addedNumbers(){
        return Arrays.asList(new Integer[][]{{3, 1, 2}, {5, 2, 3},{7, 3, 4},{9, 4, 5}});
    }

    @Test
    public void sum(){
        Calculate add = new Calculate();
        System.out.println("Addition with parameters :"+ first + "and" + second);
        assertEquals(expected, add.sum(first, second));
    }
}

/**
 * 在IDEA2019.3中的输出结果是:
 * =======================
 * Addition with parameters :1and2
 * 相加的值是:1+2
 * Addition with parameters :2and3
 * 相加的值是:2+3
 * Addition with parameters :3and4
 * 相加的值是:3+4
 * Addition with parameters :4and5
 * 相加的值是:4+5
 * =======================
 * 结论：没得问题，OJBK
 * */