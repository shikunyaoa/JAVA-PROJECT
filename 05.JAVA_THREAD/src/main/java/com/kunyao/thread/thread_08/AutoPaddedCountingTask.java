package com.kunyao.thread.thread_08;

/**
 * @ClassName: AutoPaddedCountingTask
 * @Author: kunyao
 * @Description: 自动填充缓存行
 * @Date: 2020/5/15 17:34
 * @Version: 1.0
 */
public class AutoPaddedCountingTask {


    private final long iterations;

    //Countended使得被注释的实例变量或者类的实例能够被加载到单独的一个缓存行之中
    @sun.misc.Contended
    public volatile long value;

    public AutoPaddedCountingTask(long iterations) {
        this.iterations = iterations;
    }
}
