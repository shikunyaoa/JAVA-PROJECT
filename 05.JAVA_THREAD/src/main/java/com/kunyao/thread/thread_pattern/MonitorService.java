package com.kunyao.thread.thread_pattern;

/**
 * @ClassName: MonitorService
 * @Author: kunyao
 * @Description: 犹豫模式
 * @Date: 2020/5/13 22:40
 * @Version: 1.0
 */
public class MonitorService {

    public volatile boolean starting;


    public void start(){
        synchronized (this){
            if(starting){
                return;
            }
            starting = true;
        }
    }
}
