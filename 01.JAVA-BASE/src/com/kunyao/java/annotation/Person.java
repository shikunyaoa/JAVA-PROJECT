package com.kunyao.java.annotation;

import java.lang.reflect.Field;

/**
 * @ClassName: Person
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/30 15:26
 * @Version: 1.0
 */
public class Person {

    @Range(min=1, max = 20)
    public String name;

    @Range(max=10)
    public String city;


    void check(Person person) throws IllegalAccessException {
        for(Field field : person.getClass().getFields()){
            Range range = field.getAnnotation(Range.class);
            if(range != null){
                Object value = field.get(person);
                if(value instanceof String){
                    String s = (String) value;
                    if(s.length() < range.min() || s.length() > range.max()){
                        throw new IllegalArgumentException("Invalid field"+ field.getName());
                    }
                }
            }
        }
    }
}
