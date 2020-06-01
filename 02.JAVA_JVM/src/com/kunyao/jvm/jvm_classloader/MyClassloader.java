package com.kunyao.jvm.jvm_classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName: MyClassloader
 * @Author: kunyao
 * @Description: 自定义类加载器
 * @Date: 2020/4/15 21:00
 * @Version: 1.0
 */
public class MyClassloader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //class文件路径
        String path = "";

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            //将字节码读取到输入流
            Files.copy(Paths.get(path), os);
            //得到字节数组
            byte[] bytes = os.toByteArray();

            //byte -> *.class
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new ClassNotFoundException("未找到字节码文件");
        }
    }
}
