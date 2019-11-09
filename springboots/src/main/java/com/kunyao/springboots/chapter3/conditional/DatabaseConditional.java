package com.kunyao.springboots.chapter3.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName DatabaseConditional
 * @Description DatabaseConditional必须实现Condition接口，实现matches方法
 * @Author kunyao
 * @Date $
 */
public class DatabaseConditional implements Condition {


    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //取出环境配置
        Environment env = conditionContext.getEnvironment();
        //判断属性文件是否存在对应的数据库配置
        return env.containsProperty("databse.driverName") &&
                env.containsProperty("database,url") &&
                env.containsProperty("database.username") &&
                env.containsProperty("database.password");

    }
}
