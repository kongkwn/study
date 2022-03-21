package com.tw.manual.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.apache.commons.lang.StringUtils.contains;

/**
 * @author: Mr.Tan
 * @description:
 * @create: 2021-03-15 11:08
 **/
public class LamBdaTest {
    public static void startThread(Runnable a) {
        (new Thread(a)).start();
    }

    public static void main(String[] args) {
        //测试lambda 规约reduce
        //test_reduce();
        //测试
        test_reduce_combiner();
    }

    public static void whenFilterList_thenSuccess() {
        List<String> names = Arrays.asList("Jack","Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter((name) ->  name.startsWith("A") || name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void test_reduce() {
        List<Integer> goodsNumber = Arrays.asList(   3, 5, 8, 4, 2, 13 );
        int sum = goodsNumber.stream().reduce(0, (a,b) -> a + b);
        //这里也可以写成这样：
        // int sum = goodsNumber.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void testLambda(String[] args) {
        // lambda表达式可以直接赋值给变量，也可以直接以参数的形式传递给方法、
        Runnable a = () -> {
            System.out.println("Hello World,Lambda...");
        };
        // JDK8之前使用匿名类来实现
        Runnable b = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World,Lambda...");
            }
        };
        startThread(a);
        startThread(() -> {
            System.out.println("Hello World,Lambda...");
        });
        whenFilterList_thenSuccess();
    }

    public static void test_reduce_combiner() {

        /** 初始化待操作的流 */
        List<Integer> nums = new ArrayList<>();
        int s = 0;
        for(int i = 0; i < 200; i ++) {
            nums.add(i);
            s = s + i;
        }

        // 对流进行归并，求和,这里使用了流的并行执行版本 parallelStream，内部使用Fork-Join框架多线程并行执行，
        // 关于流的内部高级特性，后续再进行深入，目前先以掌握其用法为主。
        int sum2 = nums.parallelStream().reduce(0,Integer::sum, Integer::sum);
        System.out.println("和为：" + sum2);

        // 下面给出上述版本的debug版本。

        // 累积器执行的次数
        AtomicInteger accumulatorCount = new AtomicInteger(0);

        // 组合器执行的次数（其实就是内部并行度）
        AtomicInteger combinerCount = new AtomicInteger(0);

        int sum = nums.parallelStream().reduce(0,(a,b) -> {
            accumulatorCount.incrementAndGet();
            return a + b;
        }, (c,d) -> {
            combinerCount.incrementAndGet();
            return  c+d;
        });

        System.out.println("accumulatorCount:" + accumulatorCount.get());
        System.out.println("combinerCountCount:" + combinerCount.get());
    }
}