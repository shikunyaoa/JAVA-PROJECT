package com.kunyao.springboots.chapter3.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName pojo
 * @Description 定义作用域， 单例Singleton和原型Prototype的区别
 * @Author kunyao
 * @Date $
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScopeBean {

}
