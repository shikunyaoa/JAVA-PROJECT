package com.kunyao.thread.thread_05;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreBasedChannel
 * @Author: kunyao
 * @Description: 基于Semaphore的支持流量控制的传输通道实现
 * @Date: 2020/5/2 20:15
 * @Version: 1.0
 */
public class SemaphoreBasedChannel<P> implements Channel {

    private final BlockingQueue<P> queue;
    private final Semaphore semaphore;

    public SemaphoreBasedChannel(BlockingQueue<P> queue, int flowLimit) {
        this(queue, flowLimit, false);
    }

    public SemaphoreBasedChannel(BlockingQueue<P> queue, int flowLimit, boolean isFair) {
        this.queue = queue;
        this.semaphore = new Semaphore(flowLimit, isFair);
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void close() throws IOException {

    }


    public void put(P product) throws InterruptedException{
        semaphore.acquire(); //申请一个配额

        try {
            queue.put(product);
        } finally {
            semaphore.release(); //返还一个配额
        }
    }
}
