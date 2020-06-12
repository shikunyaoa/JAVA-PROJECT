package com.kunyao.java.refactor_01;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @ClassName: Customer
 * @Author: kunyao
 * @Description: 重构实体类-Customer
 * @Date: 2020/6/12 15:55
 * @Version: 1.0
 */
public class Customer {

    private String _name;
    private Vector rens = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental rental){
        rens.add(rental);
    }

    public String get_name() {
        return _name;
    }

    public String statement(){
        Enumeration rentals = rens.elements();
        String result = "Rental Record for " + get_name() + "\n";
        while(rentals.hasMoreElements()){
            Rental rental = (Rental) rentals.nextElement();
            result += "\t" + rental.getMoive().get_title() + "\t" + String.valueOf(rental.getThisAmount()) + "\n";
        }
        result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned" + String.valueOf(getTotalFrequentRenterPointes()) + "frequent renter points";
        return result;
    }



    //Move Method
    public double getThisAmount(Rental rental){
        return rental.getThisAmount();
    }


    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = rens.elements();
        while(rentals.hasMoreElements()){
            Rental rental = (Rental) rentals.nextElement();
            result += rental.getThisAmount();
        }
        return result;
    }


    private double getTotalFrequentRenterPointes(){
        double result = 0;
        Enumeration rentals = rens.elements();
        while(rentals.hasMoreElements()){
            Rental rental = (Rental) rentals.nextElement();
            result += rental.getFrequentRenterPointes();
        }
        return result;
    }
}
