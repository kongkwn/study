package com.tw.manual.example;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Mr.Tan
 * @description:
 * @create: 2021-04-12 14:33
 **/
public class TestLambdaSorted {
    public static void main(String[] args) {
        testSortedForArr();
    }

    public static void testSortedForArr() {
        String[] atp = {"2016-06-28 08:00:00", "2017-12-05 19:17:32","2017-03-06 22:14:51","2016-12-28 08:00:00", "2017-03-05 19:17:32","2017-03-06 22:14:51"};
        List<String> list = Arrays.stream(atp).sorted((String s1, String s2) -> (s1.compareTo(s2))).collect(Collectors.toList());
        list.stream().forEach(s -> System.out.println(s));
        //list.stream().limit(3).forEach(s -> System.out.println(s));
        //Arrays.stream(atp).forEach(s -> System.out.println(s));
    }
}
