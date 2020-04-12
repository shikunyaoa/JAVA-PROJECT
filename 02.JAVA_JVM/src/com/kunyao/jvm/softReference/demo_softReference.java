package com.kunyao.jvm.softReference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: demo_softReference
 * @Author: kunyao
 * @Description: 演示软引用，配合引用队列
 * @Date: 2020/4/11 19:05
 * @Version: 1.0
 */
public class demo_softReference {

    private static final int  _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {

        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5 ; i++) {
            //关联引用队列，当软引用所关联的byte[]被回收时，
            //软引用会自己加入到队列中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        //从队列中得到无用的软引用，然后删除
        Reference<? extends byte[]> poll  = queue.poll();
        while(poll != null){
            list.remove(poll);
            poll = queue.poll();
        }

        for (SoftReference<byte[]> reference: list
             ) {
            System.out.println(reference);
        }
    }
}
