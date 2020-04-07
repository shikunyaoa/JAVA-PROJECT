package com.kunyao.java.design_patterns.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @ClassName: ReverseArrayCollection
 * @Author: kunyao
 * @Description: 迭代器模式：提供一种方法顺序访问一个聚合对象中的各个元素，而又不需要暴露该对象的内部表示。
 * @Date: 2020/4/7 13:47
 * @Version: 1.0
 */
public class ReverseArrayCollection<T> implements Iterable<T> {
    private T[] array;

    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator();
    }

    class ReverseIterator implements Iterator<T> {
        // 索引位置:
        int index;

        public ReverseIterator() {
            // 创建Iterator时,索引在数组末尾:
            this.index = ReverseArrayCollection.this.array.length;
        }

        @Override
        public boolean hasNext() {
            // 如果索引大于0,那么可以移动到下一个元素(倒序往前移动):
            return index > 0;
        }

        @Override
        public T next() {
            // 将索引移动到下一个元素并返回(倒序往前移动):
            index--;
            return array[index];
        }
    }
}