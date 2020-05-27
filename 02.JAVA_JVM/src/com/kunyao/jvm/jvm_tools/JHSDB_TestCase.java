package com.kunyao.jvm.jvm_tools;



/**
 * @ClassName: JHSDB_TestCase
 * @Author: kunyao
 * @Description: JHSDB: 基于服务性代理的调试工具
 * @Date: 2020/5/27 17:18
 * @Version: 1.0
 */
public class JHSDB_TestCase {

    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static  class ObjectHolder{}

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
