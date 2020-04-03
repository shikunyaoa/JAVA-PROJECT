package com.kunyao.java.function;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: function_stream
 * @Author: kunyao
 * @Description: stream：代表对象的序列，但是不存在与内存
 * @Date: 2020/4/3 11:27
 * @Version: 1.0
 */
public class function_stream {
    public static void main(String[] args) {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);


        //输出为List
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream.filter(s -> s != null ).collect(Collectors.toList());
        System.out.println(list);


        //输出为map
        Stream<String> stream2 = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream2
                .collect(Collectors.toMap(
                        // 把元素s映射为key:
                        s -> s.substring(0, s.indexOf(':')),
                        // 把元素s映射为value:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);


        //分组输出
        //List<String> list2 = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        //分组输出使用Collectors.groupingBy()，
        // 它需要提供两个函数：一个是分组的key，这里使用s -> s.substring(0, 1)，表示只要首字母相同的String分到一组，
        // 第二个是分组的value
        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int x = 0;
    int y = 0;
    int z = 0;

    @Override
    public Integer get() {
        if(x == 0) {
            x++;
        }else{
            z = x;
            x = x + y;
            y = z;
        }
        return x;
    }
}