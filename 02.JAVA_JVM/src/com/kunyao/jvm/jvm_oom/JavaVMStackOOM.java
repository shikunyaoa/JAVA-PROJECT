package com.kunyao.jvm.jvm_oom;

/**
 * @ClassName: JavaVMStackOOM
 * @Author: kunyao
 * @Description: 栈内存溢出异常
 * @Date: 2020/5/21 22:05
 * @Version: 1.0
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(()->{
                dontStop();
            });

            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
