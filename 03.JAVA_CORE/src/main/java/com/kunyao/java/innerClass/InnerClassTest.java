package com.kunyao.java.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * @ClassName: InnerClassTest
 * @Author: kunyao
 * @Description: 内部类测试
 * @Date: 2020/4/20 20:00
 * @Version: 1.0
 */
public class InnerClassTest {

    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, true);
        talkingClock.start();

        JOptionPane.showMessageDialog(null , "Quit program");
        System.exit(0);
    }
}

class TalkingClock{

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        // ActionListener listener = new TimePrinter(this);
        //编译器会将this传递给TimePrinter
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public class  TimePrinter implements ActionListener{

        //编译器修改了所有的内部类的构造器，添加一个外围类引用的参数
        //因为TimePrinter没有构造器，所以编译器会为这个类生成一个默认的构造器

//        public TimePrinter(TalkingClock clock){
//            outer = clock;
//        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is" +new Date());
            //此处可以看做是outer.beep, outer即外围类对象的引用
            if(beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
