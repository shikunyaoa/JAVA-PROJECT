package com.kunyao.jvm.jvm_gc;

/**
 * @ClassName: TestPretenureSizeThreshold
 * @Author: kunyao
 * @Description: 大对象直接进入老年代
 * @Date: 2020/5/24 23:20
 * @Version: 1.0
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[9 * _1MB];
    }
    /**
     * Heap
     *  PSYoungGen      total 9216K, used 2851K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 8192K, 34% used [0x00000000ff600000,0x00000000ff8c8fa0,0x00000000ffe00000)
     *   from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *   to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     *  ParOldGen       total 10240K, used 9216K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 90% used [0x00000000fec00000,0x00000000ff500010,0x00000000ff600000)
     *  Metaspace       used 3328K, capacity 4556K, committed 4864K, reserved 1056768K
     *   class space    used 361K, capacity 392K, committed 512K, reserved 1048576K
     */
}
