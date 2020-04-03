package com.kunyao.java.design_patterns.bridge;

/**
 * @ClassName: BossCar
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 14:48
 * @Version: 1.0
 */
public class BossCar extends RefinedCar {


    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "boss";
    }
}
