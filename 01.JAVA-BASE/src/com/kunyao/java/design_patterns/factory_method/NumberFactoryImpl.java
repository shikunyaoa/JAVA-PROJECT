package com.kunyao.java.design_patterns.factory_method;

import java.math.BigDecimal;

/**
 * @ClassName: NumberFactoryImpl
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 13:44
 * @Version: 1.0
 */
public class NumberFactoryImpl implements NumberFactory {
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
