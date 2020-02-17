package com.kunyao.JUnit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: AssertionsTest
 * @Author: kunyao
 * @Description: Junit断言
 * @Date: 2020/2/17 16:04
 * @Version: 1.0
 */
public class AssertionsTest {

    @Test
    public void test(){
        String obj1 = "junit";
        String obj2 = "junit";
        String obj3 = "test";
        String obj4 = "test";
        String obj5 = null;
        int[] arithmetic1 = {1, 2, 3};
        int[] arithmetic2 = {1, 2, 3};

        //断言两个值相等，值得类型可能是int,short, long, byte, char or java.lang,Object
        assertEquals(obj1, obj2);
        //断言，两个对象引用相同的对象
        assertSame(obj3, obj4);
        //断言，两个对象不是引用同一个对象
        assertNotSame(obj2, obj4);
        //断言一个对象不为空
        assertNotNull(obj1);
        //断言一个对象为空
        assertNull(obj5);

        //断言一个条件为真
        assertTrue(obj1.equals(obj2));
        //断言预期数组和结果数组相等
        assertArrayEquals(arithmetic1, arithmetic2);
        System.out.println("This is Assertions.class");
    }
}

/**
 * 在IDEA2019.3中的输出结果是:
 * =======================
 *
 * =======================
 * 结论：没得问题，OJBK
 * */