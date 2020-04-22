package com.kunyao.java.stream;

import com.sun.xml.internal.bind.api.impl.NameConverter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StreamTest
 * @Author: kunyao
 * @Description: 流库的测试
 * @Date: 2020/4/22 21:35
 * @Version: 1.0
 */
public class StreamTest {

    public static void main(String[] args) throws IOException {

        String contains = new String(Files.readAllBytes(Paths.get("D:\\open-source\\JAVA-PROJECT\\03.JAVA_CORE\\src\\main\\java\\com\\kunyao\\java\\proxy\\ProxyTest.java")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contains.split("\\PL+"));

        //filter会生成一个新的流，其中不包含被过滤掉的元素
        long count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);  //4
    }
}
