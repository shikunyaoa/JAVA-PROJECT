package com.kunyao.java.refactor_01;

/**
 * @ClassName: Price
 * @Author: kunyao
 * @Description: 抽象类
 * @Date: 2020/6/12 17:08
 * @Version: 1.0
 */
abstract class Price {

    abstract int getPirceCode();

    abstract double getThisAmount(int daysRented);

    abstract int getFrequentRenterPointes(int daysRented);
}
