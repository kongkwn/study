package com.tw.manual.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 9:42 2019/7/12
 */
public class MapForeach {
    public static void main(String[] args) {
        //使用com.google.guava包创建集合
        List<String> list = Lists.newArrayList("a", "b", "c", "d");

        //遍历1  其中anyThing可以用其它字符替换
        list.forEach((anyThing) -> System.out.println(anyThing));
        //遍历2
        list.forEach(any -> System.out.println(any));
        //匹配输出 : "b"
        list.forEach(item -> {
            if ("b".equals(item)) {
                System.out.println(item);
            }
        });

        Map map = Maps.newHashMap();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.forEach((key,value)->{
            if(Objects.equals("1",key)){
                System.out.println(value);
            }else{
                System.out.println("haha");
            }
        });
    }
}
