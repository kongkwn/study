package com.tw.manual.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tanwei
 * @Description:创建一个定长线程池，支持定时及周期性任务执行。延迟执行
 * @Date: Create in 15:50 2019/7/23
 */
public class NewScheduledPoolTest {
    public static void main(String[] args) {
        // 创建一个定长线程池，支持定时及周期性任务执行。延迟执行
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);

        newScheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延时3秒执行");
            }
        },3, TimeUnit.SECONDS);

        newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒并3秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);

    }
}
