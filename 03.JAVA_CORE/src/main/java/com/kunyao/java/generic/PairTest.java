package com.kunyao.java.generic;

import java.time.*;

/**
 * @ClassName: PairTest
 * @Author: kunyao
 * @Description: 泛型
 * @Date: 2020/4/21 19:24
 * @Version: 1.0
 */
public class PairTest {

    public static void main(String[] args) {

        LocalDate[] birthday = {
                LocalDate.of(1996, 12, 9),
                LocalDate.of(1995, 12, 9),
                LocalDate.of(1994, 12, 9),
        };
        Pair<LocalDate> pair = ArrayAlg.minmax(birthday);
        System.out.println("min = " + pair.getFirst() );
        System.out.println("max = " + pair.getSecond() );
    }
}


class ArrayAlg{

    //<T extends Comparable> 表示T应该是绑定类型的子类型
    //因为只有实现了Comparable的才能调用compareTo
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a == null || a.length == 0){
            return null;
        }
        T max = a[0];
        T min = a[0];
        for (int i = 0; i < a.length ; i++) {
            if(min.compareTo(a[i]) > 0){
                min = a[i];
            }
            if(max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<T>(min, max);
    }

}

class Pair<T> {

    private T first;

    private T second;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
