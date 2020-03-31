package com.kunyao.java.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName: Dates
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/31 11:09
 * @Version: 1.0
 */
public class Dates {

    public static void main(String[] args) {

        //当前日期
        LocalDate  localDate = LocalDate.now();

        //当前时间
        LocalTime localTime = LocalTime.now();

        //当前日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();

        localDate = localDateTime.toLocalDate(); //转换为当前日期
        localTime = localDateTime.toLocalTime(); //转换为当前时间

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println(localDate); //2020-03-31
        System.out.println(localTime); //11:11:28.343
        System.out.println(localDateTime); //2020-03-31T11:11:28.343
        System.out.println(dateTimeFormatter.format(LocalDateTime.now())); //2020/03/31 11:14:51
    }
}
