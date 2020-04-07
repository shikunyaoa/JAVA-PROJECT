package com.kunyao.java.design_patterns.chain_of_Responsibility;

import java.math.BigDecimal;

/**
 * @ClassName: Request
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/7 13:23
 * @Version: 1.0
 */
public class Request {

    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
