package com.kunyao.springboots.chapter3.pojo;

import com.kunyao.springboots.chapter3.pojo.definition.Animal;
import com.kunyao.springboots.chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName BussinessPerson
 * @Description 人类实现类
 * @Author kunyao
 * @Date $
 */
@Component("BussinessPerson")
public class BussinessPerson implements Person {

    //@Autowired会根据属性的类型（by type)找到对应的Bean进行注入
    @Autowired
    private Animal animal = null;
    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
