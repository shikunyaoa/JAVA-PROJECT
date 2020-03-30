package com.kunyao.java.reflection;

/**
 * @ClassName: reflection_getClass
 * @Author: kunyao
 * @Description: 通过反射获取class的Class
 * @Date: 2020/3/27 17:38
 * @Version: 1.0
 */
public class reflection_getClass {

    /**
     *  JVM为每个加载的class创建了对应的Class实例，并在该实例中保存了所有的信息，包括类名、包名、父类、实现的接口、所有方法、字段等
     *  通过Class获取class信息的方法称为反射
     */

    /**
     * 获取一个class的Class实例
     * 1.通过一个class的静态变量获取
     */
    Class cls = String.class;


    /**
     * 2.通过getClass
     */
    String str = "hello";
    Class cls2 = str.getClass();


    /**
     * 通过静态方法Class.forName
     */
    Class cls3;

    {
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
