package com.kunyao.java.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: thread_condition
 * @Author: kunyao
 * @Description:
 * @Date: 2020/4/2 17:54
 * @Version: 1.0
 */
public class thread_condition {
}

/**
 * 通过ReentrantLock和Condition来实现条件不满足时等待，条件满足时唤醒
 *
 *
 * await()会释放当前锁，进入等待状态；
 *
 * signal()会唤醒某个等待线程；
 *
 * signalAll()会唤醒所有等待线程；
 *
 * 唤醒线程从await()返回后需要重新获得锁
 */
class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return queue.remove();
    }
}
