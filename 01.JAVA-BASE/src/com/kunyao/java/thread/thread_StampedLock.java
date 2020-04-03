package com.kunyao.java.thread;

import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName: thread_StampedLock
 * @Author: kunyao
 * @Description: 乐观读写锁：乐观锁的意思就是乐观地估计读的过程中大概率不会有写入，因此被称为乐观锁
 * @Date: 2020/4/3 9:36
 * @Version: 1.0
 */
public class thread_StampedLock {

    private final StampedLock stampedLock = new StampedLock();

    private double x;

    private double y;

    public void set(double newX, double newY) {
        long stamp = stampedLock.writeLock(); //获取写锁

        try {
            x += newX;
            y += newY;
        } finally {
            stampedLock.unlockWrite(stamp); //释放写锁
        }
    }

    public double get(){
        long stamp = stampedLock.tryOptimisticRead(); //获取乐观读锁

        //此处 x,y可能已经被写锁修改了
        double currentX = x;

        double currentY = y;

        if(!stampedLock.validate(stamp)) { //检查乐观读锁后是否有其他写锁发生
            stamp = stampedLock.readLock(); //获取悲观读锁

            try{
                currentX = x;
                currentY = y;
            }finally {
                stampedLock.unlockRead(stamp); //释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
