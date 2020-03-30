package com.kunyao.java.genericity;

/**
 * @ClassName: Person
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/30 16:42
 * @Version: 1.0
 */

/**
 * 泛型就是代码模板
 *
 * 实现Comparable<T>泛型方法，Person实例对象数组就可以进行排序
 */
public class Person implements Comparable<Person> {

    public String username;

    public int score;

    @Override
    public int compareTo(Person o) {
        return this.username.compareTo(o.username);
    }


}
//java泛型的实现方式是擦拭法，编译器会把T都视为object进行处理，但是，在需要转型的时候，编译器会会根据T的类型安全的进行强制类型转换

/**
 *
 * 泛型的局限性
 * 1.T都被视为Object,所以不能为基本数据类型
 * 2.T都被视为Object,无法获取泛型的Class,无论T是什么类型，编译后都是Object
 * 3.无法判断带泛型的Class
 * 4.无法实例化泛型类
 * @param <T>
 * @param <k>
 */
class  Person2<T, k> {

    public T username;

    public k password;

    public Person2(T t, k k){
        this.username = t;
        this.password = k;
    }

    public static <T, k> Person2<T, k> create(T first, k last) {
        return new Person2<T, k>(first, last);
    }
}

/**
 * <T extends Number>通配符限定T的类型，可以是Number的子类，也可以是Number本身
 * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）
 *
 *
 * <? super T>:表示方法接收所有泛型类型为Integer或Integer父类额Person3类型
 * <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
 *
 * 无限定通配符<?> 既不能读也不能写
 */
class Person3<T extends Number>{

    void set(Person3<? super Integer> p) {
    }

    static boolean isNull(Person3<?> p) {
        return true;
    }
}



