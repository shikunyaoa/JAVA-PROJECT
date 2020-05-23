package com.kunyao.jvm.jvm_gc;

/**
 * @ClassName: TestAllocation
 * @Author: kunyao
 * @Description: 对象在内存中的分配
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Date: 2020/5/23 22:49
 * @Version: 1.0
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[ 2 * _1MB];
        allocation2 = new byte[ 2 * _1MB];
        allocation3 = new byte[ 2 * _1MB];
        //出现一次Monor GC，因为Eden所剩内存不足以分配给allocation4
        allocation4 = new byte[ 4 * _1MB];

    }

    /**
     * [GC (Allocation Failure) [PSYoungGen: 6783K->783K(9216K)] 6783K->4887K(19456K), 0.0256370 secs] [Times: user=0.00 sys=0.00, real=0.09 secs]
     * Heap
     *  PSYoungGen      total 9216K, used 7331K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 8192K, 79% used [0x00000000ff600000,0x00000000ffc64fe0,0x00000000ffe00000)
     *   from space 1024K, 76% used [0x00000000ffe00000,0x00000000ffec3cc0,0x00000000fff00000)
     *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *  ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
     *  Metaspace       used 3328K, capacity 4556K, committed 4864K, reserved 1056768K
     *   class space    used 361K, capacity 392K, committed 512K, reserved 1048576K
     */
}
