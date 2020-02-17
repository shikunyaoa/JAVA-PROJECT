package com.kunyao.JUnit;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @ClassName: AnnotationsTest
 * @Author: kunyao
 * @Description:    Junit中注解的使用
 * @Date: 2020/2/17 15:44
 * @Version: 1.0
 */
public class AnnotationsTest {

    private ArrayList arrayList;

    @BeforeClass
    public static void onceExecutedBeforeAll(){
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }

    @Before
    public void executedBeforeEach(){
        arrayList = new ArrayList();
        System.out.println("@Before: executedBeforeEach");
    }

    @AfterClass
    public static void onceExecutedAfterAll(){
        System.out.println("@AfterClass: onceExecutedAfterAll");
    }

    @After
    public void executedAfterEach(){
        arrayList.clear();
        System.out.println("@After: executedAfterEach");
    }

    @Test
    public void EmptyCollection(){
        assertTrue(arrayList.isEmpty());
        System.out.println("@Test: EmptyArrayList");
    }

    @Test
    public void OneItemCollection(){
        arrayList.add("oneItem");
        assertEquals(1, arrayList.size());
        System.out.println("@Test: OneItemArrayList");
    }

    @Ignore
    public void executedIgnored(){
        System.out.println("@Ignore: This execution is ignored");
    }

}

/**
 * 在IDEA2019.3中的输出结果是:
 * =======================
 * @BeforeClass: onceExecutedBeforeAll
 * @Before: executedBeforeEach
 * @Test: EmptyArrayList
 * @After: executedAfterEach
 * @Before: executedBeforeEach
 * @Test: OneItemArrayList
 * @After: executedAfterEach
 * @AfterClass: onceExecutedAfterAll
 * =======================
 * 结论：BeforeClass,AfterClass只执行一次；Before，After在每个Test前后各执行一次
 * */
