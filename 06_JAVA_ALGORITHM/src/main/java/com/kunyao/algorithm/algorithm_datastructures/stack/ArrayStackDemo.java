package com.kunyao.algorithm.algorithm_datastructures.stack;

/**
 * @ClassName: ArrayStackDemo
 * @Author: kunyao
 * @Description: 数组实现的stack
 * @Date: 2020/6/8 21:01
 * @Version: 1.0
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

        //中缀表达式
        String expression = "30*2+1-3";
        ArrayStack numberStack = new ArrayStack(10);
        ArrayStack oprStack = new ArrayStack(10);
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        int opr = 0;
        int index = 0;
        char ch = ' ';

        String keepNum = "";
        while(true){
            ch = expression.substring(index, index + 1).charAt(0);
            if(oprStack.isOper(ch)){
                if(!oprStack.isEmpty()){
                    if(oprStack.priority(ch) <= oprStack.priority(oprStack.peek())){
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        opr = oprStack.pop();
                        sum = numberStack.cal(num1, num2, opr);
                        numberStack.push(sum);
                        oprStack.push(ch);
                    }else{
                        oprStack.push(ch);
                    }
                }else{
                    oprStack.push(ch);
                }
            }else{
                //可能是多位的数字
                keepNum += ch;

                //当是最后一位时，直接入栈
                if(index == expression.length() - 1){
                    numberStack.push(Integer.parseInt(keepNum));
                }else{

                    if(oprStack.isOper(expression.substring(index +1, index + 2).charAt(0))){
                        numberStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }

            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        while(true){
            if(oprStack.isEmpty()){
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            char c = (char) oprStack.pop();
            sum = numberStack.cal(num1, num2, c);
            numberStack.push(sum);
        }

        System.out.println(numberStack.peek());
    }
}


class ArrayStack{

    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }


    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int peek(){
        return stack[top];
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("栈为空");
            return -1;
        }
        int value = stack[top];
        top--;
        return value;
    }


    public void List(){
        if(isEmpty()){
            System.out.println("栈为空");
        }

        for (int i = top; i >= 0 ; i--) {
            System.out.printf("栈值%d = %d \n", i, stack[i]);
        }
    }


    public boolean isOper(char ch){
        return ch == '*' || ch == '/' || ch == '-' || ch == '+';
    }

    public int priority(int opr){
        if(opr == '*' || opr == '/'){
            return 1;
        }else if(opr == '-' || opr == '+'){
            return 0;
        }else{
            return -1;
        }
    }

    public int cal(int num1, int num2, int ch){
        int sum = 0;
        switch (ch){
            case '*':
                sum = num2 * num1;
                break;
            case '/':
                sum = num2 / num1;
                break;
            case '-':
                sum = num2 - num1;
                break;
            case '+':
                sum = num2 + num1;
                break;
            default:
                break;
        }

        return sum;
    }
}
