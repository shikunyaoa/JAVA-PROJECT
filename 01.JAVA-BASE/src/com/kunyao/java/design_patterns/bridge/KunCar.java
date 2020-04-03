package com.kunyao.java.design_patterns.bridge;

/**
 * @ClassName: KunCar
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 14:51
 * @Version: 1.0
 */
public class KunCar extends RefinedCar {

    public KunCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "kunCar";
    }
}
