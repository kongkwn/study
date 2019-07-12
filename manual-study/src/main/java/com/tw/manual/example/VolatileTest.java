package com.tw.manual.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 11:09 2019/7/12
 */
public class VolatileTest {
    //public static volatile int race = 0;

    private static final int THREADS_COUNT = 20;

    public static AtomicInteger race=new AtomicInteger(0);

    /*public static synchronized void increase() {
        race++;
    }*/
    public static void increase(){
        race.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);

        Thread.currentThread().getThreadGroup().list();
    }
}
