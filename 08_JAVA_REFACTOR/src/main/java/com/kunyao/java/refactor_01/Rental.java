package com.kunyao.java.refactor_01;

/**
 * @ClassName: Rental
 * @Author: kunyao
 * @Description: 重构实体类-Rental:表示某个顾客租了影片
 * @Date: 2020/6/12 15:53
 * @Version: 1.0
 */
public class Rental {

    private Moive moive;
    private int _daysRented;

    public Rental(Moive moive, int _daysRented) {
        this.moive = moive;
        this._daysRented = _daysRented;
    }

    public Moive getMoive() {
        return moive;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public double getThisAmount() {
        return moive.getThisAmount(_daysRented);
    }


    public int getFrequentRenterPointes() {
      return moive.getFrequentRenterPointes(_daysRented);
    }
}
