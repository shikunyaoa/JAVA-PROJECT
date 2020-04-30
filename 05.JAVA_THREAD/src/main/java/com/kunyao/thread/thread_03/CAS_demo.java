package com.kunyao.thread.thread_03;

import com.sun.org.apache.xpath.internal.operations.Variable;

/**
 * @ClassName: CAS_demo
 * @Author: kunyao
 * @Description: CAS实例
 * @Date: 2020/4/30 13:23
 * @Version: 1.0
 */
public class CAS_demo {

    private volatile long count;

    public long value(){
        return count;
    }


    public void increment(){
        long oldValue;
        long newValue;
        do{
            oldValue = count;
            newValue = oldValue + 1;
        }while(!compareAndSwap(oldValue, newValue));
    }

    private boolean compareAndSwap(long oldValue, long newValue) {
        if(oldValue == value()){
            count = newValue;
            return true;
        }

        return false;
    }
}
