package com.kunyao.java.design_patterns.bridge;

/**
 * @ClassName: HybridEngine
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/3 14:49
 * @Version: 1.0
 */
public class HybridEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Start Hybrid Engine...");
    }
}