package com.kunyao.algorithm.algorithm_datastructures.greedy;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName: GreedyAlgorithm
 * @Author: kunyao
 * @Description: 集合覆盖问题 - 贪心算法
 * @Date: 2020/6/28 19:47
 * @Version: 1.0
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {

        //创建map存储电台
        Map<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        //存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，存放交集
        HashSet<String> tempSet = new HashSet<>();

        //保存在一次遍历过程中，能够覆盖最大未覆盖的地区的电台的key
        String maxKey = null;
        while(allAreas.size() > 0){
            maxKey = null;
            for (String key : broadcasts.keySet()){
                tempSet.clear();
                //当前key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //将交集赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合的未包含的数量比maxkey指向的集合地区还多
                //就需要重置maxkey
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if(maxKey != null){
                //将maxkey加入到选择集合中
                selects.add(maxKey);
                //并将maxkey指向的广播电台覆盖的地区，从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
    }



}
