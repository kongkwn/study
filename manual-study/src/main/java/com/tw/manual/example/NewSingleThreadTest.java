package com.tw.manual.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 16:30 2019/7/23
 */
public class NewSingleThreadTest {
    public static void main(String[] args) {
        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
        // 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("执行：" + index + "线程名称:" + threadName);
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
