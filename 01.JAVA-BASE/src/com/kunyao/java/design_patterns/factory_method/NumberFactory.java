package com.kunyao.java.design_patterns.factory_method;

public interface NumberFactory {

    Number parse(String s);

    static NumberFactory getFactory() {
        return impl;
    }

    /**
     * 总是引用接口而非实现类，能允许变换子类而不影响调用方，即尽可能面向抽象编程。
     */
    static NumberFactory impl = new NumberFactoryImpl();
}
