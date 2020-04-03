package com.kunyao.java.design_patterns.bridge;

/**
 * @ClassName: Main
 * @Author: kunyao
 * @Description: 桥接模式：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * @Date: 2020/4/3 14:50
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        RefinedCar car = new BossCar(new HybridEngine());
        car.drive();


        RefinedCar car2 = new KunCar(new HybridEngine());
        car2.drive();
    }
}
