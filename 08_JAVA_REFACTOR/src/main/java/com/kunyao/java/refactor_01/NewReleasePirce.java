package com.kunyao.java.refactor_01;

/**
 * @ClassName: NewReleasePirce
 * @Author: kunyao
 * @Description:
 * @Date: 2020/6/12 17:10
 * @Version: 1.0
 */
public class NewReleasePirce extends Price {
    @Override
    int getPirceCode() {
        return Moive.NEW_RELEASE;
    }

    @Override
    public double getThisAmount(int daysRented) {
        return daysRented  * 3;
    }

    @Override
    int getFrequentRenterPointes(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
