package com.kunyao.springboots.chapter3.pojo;

import com.kunyao.springboots.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @ClassName Dog
 * @Description 狗的实现类
 * @Author kunyao
 * @Date $
 */
@Component("Dog")
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗【" + Dog.class.getSimpleName() + "】是用来看门的");
    }
}
