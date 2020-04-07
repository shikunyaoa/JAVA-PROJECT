package com.kunyao.java.design_patterns.chain_of_Responsibility;

import java.math.BigDecimal;

/**
 * @ClassName: DirectorHandler
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/7 13:26
 * @Version: 1.0
 */
public class DirectorHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        return !request.getName().equalsIgnoreCase("bob");
    }
}
