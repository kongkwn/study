package com.tw.manual.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: tanwei
 * @Description:线程池 参考博客：https://blog.csdn.net/achuo/article/details/80623893
 * @Date: Create in 14:58 2019/7/23
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程
        // 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
        // 此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，
        // 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("执行:" + index + "线程名称:" + threadName);
                }
            });


        }
    }
}
