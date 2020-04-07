package com.kunyao.java.design_patterns.chain_of_Responsibility;

import java.math.BigDecimal;

/**
 * @ClassName: Main
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/7 13:29
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {

        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());

        chain.process(new Request("Bob", new BigDecimal("123.45")));
    }
}
