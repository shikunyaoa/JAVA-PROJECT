package com.kunyao.thread.thread_08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @ClassName: DateTimeFormatterDemo
 * @Author: kunyao
 * @Description: 不可变对象
 * @Date: 2020/5/16 19:14
 * @Version: 1.0
 */
public class DateTimeFormatterDemo {

    public static void main(String[] args) {

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");*/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 1000 ; i++) {
            new Thread(()->{
                TemporalAccessor parse = dtf.parse("1923-03-03");
                System.out.println(parse);
            }, "名称" + i).start();
        }
    }
}
