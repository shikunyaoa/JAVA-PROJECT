package com.kunyao.jvm.jvm_oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HeapOOM
 * @Author: kunyao
 * @Description: Java堆内存溢出异常测试
 *
 * -Xms 堆的最小值
 * -Xmx 堆的最大值
 * 将最小值与最大值设置为一样即可避免堆自动扩展
 * -XX:+HeapDumpOnOutOfMemoryError可以让让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照
 * @Date: 2020/5/20 20:59
 * @Version: 1.0
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at java.util.Arrays.copyOf(Arrays.java:3210)
     * 	at java.util.Arrays.copyOf(Arrays.java:3181)
     * 	at java.util.ArrayList.grow(ArrayList.java:261)
     * 	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
     * 	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
     * 	at java.util.ArrayList.add(ArrayList.java:458)
     * 	at com.kunyao.jvm.jvm_oom.HeapOOM.main(HeapOOM.java:27)
     */
}
