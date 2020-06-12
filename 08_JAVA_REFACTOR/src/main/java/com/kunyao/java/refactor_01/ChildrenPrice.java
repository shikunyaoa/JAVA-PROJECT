package com.kunyao.java.refactor_01;

/**
 * @ClassName: ChildrenPrice
 * @Author: kunyao
 * @Description:
 * @Date: 2020/6/12 17:10
 * @Version: 1.0
 */
public class ChildrenPrice extends Price {

    @Override
    int getPirceCode() {
        return Moive.CHILDRENS;
    }

    @Override
    public double getThisAmount(int daysRented) {
        double thisAmount = 1.5;
        if(daysRented > 3){
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
    }

    @Override
    int getFrequentRenterPointes(int daysRented) {
        return 1;
    }
}
