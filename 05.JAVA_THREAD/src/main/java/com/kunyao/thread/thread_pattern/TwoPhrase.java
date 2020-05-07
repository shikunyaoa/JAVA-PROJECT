package com.kunyao.thread.thread_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TwoPhrase
 * @Author: kunyao
 * @Description: 两阶段终止模式
 * @Date: 2020/5/7 20:18
 * @Version: 1.0
 */
@Slf4j(topic = "c.TwoPhrase")
public class TwoPhrase {

    public static void main(String[] args) throws InterruptedException {

        TwoPhraseDemo t = new TwoPhraseDemo();

        t.start();
        t.interrupt();
    }
}

@Slf4j(topic = "c.TwoPhraseDemo")
class TwoPhraseDemo{

    private Thread monitor;

    public void start(){
        monitor = new Thread(() -> {
            while(true){
                log.debug("运行ing.........");
                Thread current = Thread.currentThread();
                //当线程正常执行即处于running状态时被interrupt后，isInterrupted()为true
                if(current.isInterrupted()){
                    log.debug("我被打断了");
                    break;
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //当线程被sleep,wait,join等即处于blocked,waiting等状态被interuupt后，isInterrupted()为false
                    //所以此处需要第二次中断即将isInterrupted()设为true
                    current.interrupt();
                }
            }
        });
        monitor.start();
    }


    public void interrupt(){
        monitor.interrupt();
    }
}