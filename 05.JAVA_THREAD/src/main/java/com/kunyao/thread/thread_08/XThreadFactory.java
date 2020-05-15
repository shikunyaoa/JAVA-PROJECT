package com.kunyao.thread.thread_08;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.Marker;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

/**
 * @ClassName: XThreadFactory
 * @Author: kunyao
 * @Description: 线程工厂
 * @Date: 2020/5/15 9:28
 * @Version: 1.0
 */
@Slf4j(topic = "c.XThreadFactory")
public class XThreadFactory implements ThreadFactory {

    private final Thread.UncaughtExceptionHandler ueh;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public XThreadFactory(){
        this(new LogginUncaughtExceptionHandler(), "thread");
    }

    public XThreadFactory(Thread.UncaughtExceptionHandler ueh, String namePrefix) {
        this.ueh = ueh;
        this.namePrefix = namePrefix;
    }

    protected Thread doMakeThread(final Runnable r){
        return new Thread(r){
            @Override
            public String toString() {
                ThreadGroup group = getThreadGroup();
                String groupName = null == group ? "": group.getName();
                String threadInfo = getClass().getSimpleName() + "[" + getName()+ ","
                        + getId() + ","
                        + groupName + "]@" + hashCode();
                return threadInfo;
            }
        };
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = doMakeThread(r);
        t.setUncaughtExceptionHandler(ueh);
        t.setName(namePrefix + "-" + threadNumber.getAndIncrement());
        if(t.isDaemon()){
            t.setDaemon(false);
        }
        if(t.getPriority() != Thread.NORM_PRIORITY){
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }

    static class LogginUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.debug((Marker) Level.SEVERE, t  + " terminated:", e);
        }
    }
}
