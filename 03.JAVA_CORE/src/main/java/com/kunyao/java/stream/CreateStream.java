package com.kunyao.java.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: CreateStream
 * @Author: kunyao
 * @Description: 流的创建
 * @Date: 2020/4/22 21:48
 * @Version: 1.0
 */
public class CreateStream {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("../alice.txt");
        String contents = new String(Files.readAllBytes(path));
        //Stream.of将数组转换为stream
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);
        //empty方法创建空的流
        Stream<String> silence = Stream.empty();
        show("silence", silence);


    }

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + ":");
        for (int i = 0; i < firstElements.size() ; i++) {
            if(i > 0) {
                System.out.println(",");
            }
            if( i < SIZE){
                System.out.println(firstElements.get(i));
            }else{
                System.out.println("....");
            }
        }
        System.out.println();
    }
}
