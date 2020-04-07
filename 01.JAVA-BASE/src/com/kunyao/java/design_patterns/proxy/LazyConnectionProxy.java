package com.kunyao.java.design_patterns.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

/**
 * @ClassName: LazyConnectionProxy
 * @Author: kunyao
 * @Description: 代理模式：为其他对象提供一种代理以控制对这个对象的访问。
 * @Date: 2020/4/7 11:25
 * @Version: 1.0
 */
public class LazyConnectionProxy extends AbstractConnectionProxy {
    private Supplier<Connection> supplier;
    private Connection target = null;

    public LazyConnectionProxy(Supplier<Connection> supplier) {
        this.supplier = supplier;
    }

    // 覆写close方法：只有target不为null时才需要关闭:
    @Override
    public void close() throws SQLException {
        if (target != null) {
            System.out.println("Close connection: " + target);
            super.close();
        }
    }

    @Override
    protected Connection getRealConnection() {
        if (target == null) {
            target = supplier.get();
        }
        return target;
    }
}