package com.kunyao.java.refactor_01;

/**
 * @ClassName: Moive
 * @Author: kunyao
 * @Description: 重构实体类-Movie
 * @Date: 2020/6/12 15:49
 * @Version: 1.0
 */
public class Moive {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price price;

    public Moive(String _title, int _priceCode) {
        this._title = _title;
        set_priceCode(_priceCode);
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return price.getPirceCode();
    }

    public void set_priceCode(int arg) {
        switch (arg){
            case REGULAR:
                price = new RegulerPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePirce();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code");

        }
    }



    public double getThisAmount(int daysRented) {
        return price.getThisAmount(daysRented);
    }

    public int getFrequentRenterPointes(int daysRented) {
        return price.getFrequentRenterPointes(daysRented);
    }
}
