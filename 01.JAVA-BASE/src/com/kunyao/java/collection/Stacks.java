package com.kunyao.java.collection;

import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName: Stacks
 * @Author: kunyao
 * @Description: 栈
 * @Date: 2020/3/31 10:03
 * @Version: 1.0
 */
public class Stacks {

    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }
    private static Stack<Integer> stack = new Stack<>();
    static String toHex(int n) {

        String res = "";


        for (int i = n; i !=0 ; i /= 16) {
            Integer result = i % 16;
            stack.push(result);
        }
        for (Integer ress: stack
             ) {
            if(ress == 10){
                res += 'A';
            }else if(ress == 11){
                res += 'B';
            }else if(ress == 12){
                res += 'C';
            }else if(ress == 13){
                res += 'D';
            }else if(ress == 14){
                res += 'E';
            }else if(ress == 15){
                res += 'F';
            }else{
                res += ress;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(res);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
