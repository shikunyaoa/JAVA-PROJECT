package com.kunyao.jvm.method_area;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @ClassName: Demo
 * @Author: kunyao
 * @Description: 演示元空间溢出 -XX:MaxMetaspaceSize=8m 指定元空间的大小
 * @Date: 2020/4/10 19:15
 * @Version: 1.0
 */
public class Demo extends ClassLoader{

    public static void main(String[] args) {

        int i = 0;
        try {
            Demo demo = new Demo();
            for (int j = 0; j < 1000; j++, i++) {
                //ClassWriter 作用是生成类的二级制字节码
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);

                byte[] code = classWriter.toByteArray();
                demo.defineClass("Class" + i, code, 0 , code.length);
            }
        } finally {
            System.out.println(i);
        }
    }
}
