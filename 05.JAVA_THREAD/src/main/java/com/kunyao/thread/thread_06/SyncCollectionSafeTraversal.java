package com.kunyao.thread.thread_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: SyncCollectionSafeTraversal
 * @Author: kunyao
 * @Description: 使用装饰器模式将非线程安全对象创建一个相应的线程安全的外包装对象
 * @Date: 2020/5/3 8:36
 * @Version: 1.0
 */
public class SyncCollectionSafeTraversal {

    final List<String> syncList = Collections.synchronizedList(new ArrayList<String>());

    public void dump(){
        Iterator<String> iterator = syncList.iterator();
        synchronized (syncList){
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
