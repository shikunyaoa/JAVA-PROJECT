package com.kunyao.thread.thread_pattern;

/**
 * @ClassName: Guarded
 * @Author: kunyao
 * @Description: 保护性暂停模式
 * @Date: 2020/5/11 20:14
 * @Version: 1.0
 */
public class Guarded {

    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();

        new Thread(()->{
            Object o = guardedObject.get();
            System.out.println(o);
        }, "t1").start();

        new Thread(()->{
            guardedObject.set("你可以继续执行了");
        },"t2").start();

    }
}


class GuardedObject{

    private Object response;



    public Object get(){
        synchronized (this){
            while(response == null){
                try {
                    System.out.println("我在等那个她");
                    this.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }


    public void set(Object response){
        synchronized (this){
            this.response = response;
            this.notifyAll();
        }
    }
}