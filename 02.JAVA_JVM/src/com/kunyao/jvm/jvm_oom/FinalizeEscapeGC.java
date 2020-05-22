package com.kunyao.jvm.jvm_oom;

/**
 * @ClassName: FinalizeEscapeGC
 * @Author: kunyao
 * @Description: 1.对象可以在被GC时自我拯救
 *               2.这种自救只有一次，因为对象finalize方法只会被自动调用一次
 * @Date: 2020/5/22 20:48
 * @Version: 1.0
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }


    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        //应为Finalizer方法优先级很低，
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead :(");
        }


        SAVE_HOOK = null;
        System.gc();

        //应为Finalizer方法优先级很低，
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead :(");
        }


    }

    /**
     * finalize method executed!
     * yes, i am still alive
     * no, i am dead :(
     */
}
