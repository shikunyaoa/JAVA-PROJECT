package com.kunyao.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ClassName: reflection_getMethod
 * @Author: kunyao
 * @Description: 通过反射获取方法
 * @Date: 2020/3/27 17:58
 * @Version: 1.0
 */
public class reflection_getMethod {

    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        //通过反射得到方法实例
        //调用invoke方法相当于调用该方法，第一个参数为对象实例，即调用哪一个实例上的该方法
        Method m = stdClass.getMethod("getName");
        String  str = (String) m.invoke(new Person());
        System.out.println(str);

        //调用静态方法，无需指定对象实例，第一个参数永远为null
        Method m2 = stdClass.getMethod("getName2");
        String str2 = (String)m2.invoke(null);
        System.out.println(str2);

        //调用私有方法时，直接调用会报错，需调用调用setAccessible()设置为true
        Method m3 = stdClass.getDeclaredMethod("getGrade", int.class);
        m3.setAccessible(true);
        int res = (int) m3.invoke(new Student(), 1);
        System.out.println(res);

        //调用构造函数
        //获取构造函数
        Constructor constructor = Integer.class.getConstructor(int.class);
        Integer integer = (Integer) constructor.newInstance(123);
        System.out.println(integer);

        //获取父类的Class
        Class i = Integer.class;
        //获取父类的类型
        Class sup = i.getSuperclass();
        System.out.println(sup);  //class java.lang.Number


        //获取当前类实现的所有接口，并不包括其父类实现的接口
        Class s = Integer.class;
        Class[] interfaces = s.getInterfaces();
        for (int j = 0; j < interfaces.length; j++) {
            System.out.println(interfaces[j]);   //class java.lang.Number interface java.lang.Comparable

        }
    }

}

class Student extends Person {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
}

class Person {
    public String getName() {
        return "Person";
    }

    public static String getName2(){return "Person2";}


}
/**
 * 在IDEA2019.3.1 JAVA8 的运行环境中的输出结果：
 * =========================================================================
 * public int com.kunyao.java.reflection.Student.getScore(java.lang.String)
 * public java.lang.String com.kunyao.java.reflection.Person.getName()
 * private int com.kunyao.java.reflection.Student.getGrade(int)
 * Person
 * Person2
 * 1
 * 123
 * class java.lang.Number
 * interface java.lang.Comparable
 * ==========================================================================
 */
