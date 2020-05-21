package com.kunyao.jvm.jvm_oom;

/**
 * @ClassName: JavaVMStackSOF
 * @Author: kunyao
 * @Description: -Xss 参数减少栈内存容量 栈溢出
 * @Date: 2020/5/21 21:59
 * @Version: 1.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length" + oom.stackLength);
            throw  e;
        }
    }
}
