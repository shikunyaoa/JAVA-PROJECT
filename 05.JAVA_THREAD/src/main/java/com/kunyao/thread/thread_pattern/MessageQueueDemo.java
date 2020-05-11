package com.kunyao.thread.thread_pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: MessageQueueDemo
 * @Author: kunyao
 * @Description: 生产者消费者模式
 * @Date: 2020/5/11 22:06
 * @Version: 1.0
 */
@Slf4j(topic = "c.MessageQueueDemo")
public class MessageQueueDemo {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                Message m = new Message(id, "消息"+id);
                messageQueue.put(m);
            }, "生产者" +i).start();
        }


        new Thread(()->{
            while(true){
                messageQueue.take();
            }
        }, "消费者").start();
    }
}

/**
 * 消息队列的抽象
 */

@Slf4j(topic = "c.MessageQueue")
class MessageQueue{
    //容器
    private LinkedList<Message> list=  new LinkedList<>();
    //限定容器的大小
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    //获取消息
    public Message take(){
        synchronized (list){
            while(list.isEmpty()){
                try {
                    log.debug("队列为空，消费者等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            //唤醒生产者线程
            log.debug("已经消费了"+ message.getValue());
            list.notifyAll();
            return message;
        }
    }

    //生产消息
    public void put(Message message){
        synchronized (list){
            while(list.size() == capcity){
                try {
                    log.debug("队列已满，生产者等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            //唤醒消费者线程
            log.debug("已经添加了"+ message.getValue());
            list.notifyAll();
        }
    }
}

/**
 * 消息的抽象
 */
final class Message{

    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }
}
