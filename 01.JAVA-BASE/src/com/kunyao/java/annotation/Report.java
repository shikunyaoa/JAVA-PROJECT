package com.kunyao.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shikunaaa
 *
 * 使用@interface来定义注解
 *
 * @Target：元注解，可以定义annotation能够应用于源码的那个地方
 * @Retention：定义annotation的生命周期
 * @Repeatable：定义annotation是否可以重复
 * @Inherited：定义子类是否可继承父类定义的Annotation
 */

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {

    //使用default指定一个默认值
    int type() default 0;

    String level() default "info";

    String value() default "";

    //通过反射读取注解

    //判断注解是否存在于Class， Field, Method 或Constructor
    //Class.isAnnotationPresent(Class)

    //读取注解
    //Class.getAnnotation(Class)
}
