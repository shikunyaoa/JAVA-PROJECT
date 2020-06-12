package com.kunyao.java.refactor_01;

/**
 * @ClassName: RegulerPrice
 * @Author: kunyao
 * @Description:
 * @Date: 2020/6/12 17:11
 * @Version: 1.0
 */
public class RegulerPrice extends Price {

    @Override
    int getPirceCode() {
        return Moive.REGULAR;
    }

    @Override
    public double getThisAmount(int daysRented) {
        double thisAmount = 2;
        if(daysRented > 2){
            thisAmount += (daysRented- 2) * 1.5;
        }
        return thisAmount;
    }

    @Override
    int getFrequentRenterPointes(int daysRented) {
        return 1;
    }
}
