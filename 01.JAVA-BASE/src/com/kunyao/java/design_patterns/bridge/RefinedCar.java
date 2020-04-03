package com.kunyao.java.design_patterns.bridge;

/**
 * @ClassName: RefinedCar
 * @Author: kunyao
 * @Description:不再使用子类扩充，而是通过一个抽象的“修正”类，以组合的形式引入
 * @Date: 2020/4/3 14:45
 * @Version: 1.0
 */
public abstract  class RefinedCar extends Car {

    public RefinedCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        this.engine.start();
        System.out.println("Drive" + getBrand() + "car");
    }

    public abstract String getBrand();
}
