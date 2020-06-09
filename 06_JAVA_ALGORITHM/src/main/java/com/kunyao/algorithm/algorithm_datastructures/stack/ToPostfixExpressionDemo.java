package com.kunyao.algorithm.algorithm_datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: ToPostfixExpressionDemo
 * @Author: kunyao
 * @Description: 中缀表达式转后缀表达式（逆波兰表达式）：
 *  思路是将符号和数字分别添加到两个栈中，在过程中根据符号的优先级逐渐将符号栈中的所有的符号添加到数栈之中
 * @Date: 2020/6/9 20:44
 * @Version: 1.0
 */
public class ToPostfixExpressionDemo {

    public static void main(String[] args) {

        String expression = "30*2+1-3";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        System.out.println("=================================");
        List<String> suffixExpression = parseSuffixExpressionList(list);
        System.out.println(suffixExpression);
    }

    //将中缀表达式转成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //符号栈
        Stack<String> s1 =  new Stack<>();
        //数链表
        List<String> s2 = new ArrayList<>();

        for(String item : ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号，则一次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //将（弹出s1栈，消除小括号
                s1.pop();
            }else{
                //将当前运算符与栈顶的进行比较，如果小于，就将栈顶的运算符压入s2
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        //将s1中剩余的运算符压入s2
        while(s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }

    public static List<String> toInfixExpressionList(String expression){
        List<String> list = new ArrayList<>();
        int index = 0;
        char ch;
        String str;

        do{
            if((ch=expression.charAt(index)) < 48 || (ch=expression.charAt(index))  > 57){
                list.add(""+ch);
                index++;
            }else{
                str = "";
                while(index < expression.length() && (ch=expression.charAt(index)) >= 48 && (ch=expression.charAt(index)) <= 57){
                    str += ch;
                    index++;
                }
                list.add(str);
            }

        }while( index < expression.length());

        return list;
    }
}

class Operation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "/":
                result = DIV;
                break;
            case "*":
                result = MUL;
                break;
            default:
                break;
        }
        return result;
    }
}

