package com.kunyao.jvm.jvm_gc;

/**
 * @ClassName: TestTenuringThreshold
 * @Author: kunyao
 * @Description: 对象年龄设置
 * -XX:MaxTenuringThreshold:设置对象晋升老年代的年龄阈值
 * @Date: 2020/5/26 17:07
 * @Version: 1.0
 */
public class TestTenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];

    }

    /**
     * -XX:MaxTenuringThreshold=1
     *
     * Heap
     *  PSYoungGen      total 9216K, used 7203K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 8192K, 87% used [0x00000000ff600000,0x00000000ffd08fb0,0x00000000ffe00000)
     *   from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *   to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     *  ParOldGen       total 10240K, used 8192K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 80% used [0x00000000fec00000,0x00000000ff400020,0x00000000ff600000)
     *  Metaspace       used 3328K, capacity 4556K, committed 4864K, reserved 1056768K
     *   class space    used 361K, capacity 392K, committed 512K, reserved 1048576K
     */
}
