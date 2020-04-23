package com.kunyao.java.io;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * @ClassName: RandomAccessTest
 * @Author: kunyao
 * @Description: 随机访问文件
 * @Date: 2020/4/23 20:50
 * @Version: 1.0
 */
public class RandomAccessTest {

    public static void main(String[] args) throws Exception {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);


        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))){
            for ( Employee e : staff
                 ) {
                wirteData(out, e);
            }
        }

        // RandomAccessFile类可以在文件中的任何位置查找或写入数据
        try(RandomAccessFile in = new RandomAccessFile("employee.dat", "r")){
            int n = (int)(in.length() / Employee.NAME_SIZE);
            Employee[] newStaff = new Employee[n];
            for (int i = n -1; i >= 0 ; i--) {
                newStaff[i] = new Employee();
                //seek方法可以用来将这个文件指针设置到文件中的任意字节位置
                in.seek(i * Employee.NAME_SIZE);
                newStaff[i] = readData(in);
            }


            for (Employee e: newStaff
                 ) {
                System.out.println(e);
            }
        }
    }


    public static void wirteData(DataOutput out, Employee e) throws Exception{
        DataIO.wirteFixedString(e.getName(), Employee.NAME_SIZE, out );
        out.writeDouble(e.getSalary());
        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }

    public static Employee readData(DataInput in) throws IOException{
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m -1, d);
    }
}


class Employee{

    public  static int NAME_SIZE = 10;
    private String name;

    private double salary;

    private LocalDate hireDay;

    private Integer num2;

    private Integer num3;

    private Integer num1;

    public Employee(){

    }
    public Employee(String name, double salary, Integer num1, Integer num2, Integer num3) {
        this.name = name;
        this.salary = salary;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }
}

class DataIO{

    public static void wirteFixedString(String s, int size, DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if(i < s.length()){
                ch = s.charAt(i);
            }
            out.writeChar(ch);
        }
    }

    public static String readFixedString(int size, DataInput in) throws IOException{
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while( more && i < size){
            char ch = in.readChar();
            i++;
            if(ch == 0){
                more = false;
            }else{
                b.append(ch);
            }
            in.skipBytes(2 * (size - i));
        }
       return b.toString();
    }
}