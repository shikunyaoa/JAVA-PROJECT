package com.kunyao.JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @ClassName: SuiteTest
 * @Author: kunyao
 * @Description:   创建套件测试，将很多测试类在同一时间运行每个测试
 * @Date: 2020/2/17 16:27
 * @Version: 1.0
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({AnnotationsTest.class, AssertionsTest.class})
public class SuiteTest {


}

/**
 * 在IDEA2019.3中的输出结果是:
 * =======================
 * @Before: executedBeforeEach
 * @Test: EmptyArrayList
 * @After: executedAfterEach
 * @Before: executedBeforeEach
 * @Test: OneItemArrayList
 * @After: executedAfterEach
 * @AfterClass: onceExecutedAfterAll
 * This is Assertions.class
 * @BeforeClass: onceExecutedBeforeAll
 * =======================
 * 结论：BeforeClass,AfterClass只执行一次；Before，After在每个Test前后各执行一次
 * */