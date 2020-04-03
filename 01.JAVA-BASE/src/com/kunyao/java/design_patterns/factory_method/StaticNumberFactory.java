package com.kunyao.java.design_patterns.factory_method;

import java.math.BigDecimal;

/**
 * @ClassName: StaticNumberFactory
 * @Author: kunyao
 * @Description: 静态工厂方法
 * @Date: 2020/4/3 13:47
 * @Version: 1.0
 */

/**
 * 工厂方法可以隐藏创建产品的细节，且不一定每次都会真正创建产品，完全可以返回缓存的产品，从而提升速度并减少内存消耗。
 */
public class StaticNumberFactory {


    static Number parse(String s){
        return new BigDecimal(s);
    }
}
