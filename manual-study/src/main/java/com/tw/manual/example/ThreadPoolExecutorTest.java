package com.tw.manual.example;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 18:04 2019/7/23
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = getThreadExecutor(3);
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    work();
                }
            });
//            Future future = threadPoolExecutor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    work();
//                }
//            });
//            future.get(); //会阻塞当前线程
            System.out.println("当前队列的剩余容量:" + threadPoolExecutor.getQueue().remainingCapacity());
        }
    }


    /**
     * corePoolSize: 核心线程数；如果不设置AllowCoreThreadTimeOut=true,则不会被销毁，即使处于闲置状态
     * maximumPoolSize: 最大线程数；= 核心线程数 + 非核心线程数
     * keepAliveTime, unit: 非核心线程的闲置后的生命周期
     * BlockingQueue: 阻塞队列；线程池提交任务时先会创建核心线程，如果核心线程不够了，则会将任务塞到队列中；如果队列也满了，则开始创建非核心线程处理任务；
     * 如果非核心线程也不够用了，则新来的任务会进入 RejectedExecutionHandler 处理。。
     * 关于 BlockingQueue，虽然它是 Queue 的子接口，但是它的主要作用并不是容器，而是作为线程同步的工具，它有一个特征，
     * 当生产者试图向 BlockingQueue 放入(put)元素，如果队列已满，则该线程被阻塞；当消费者试图从 BlockingQueue 取出(take)元素，如果队列已空，则该线程被阻塞。
     *
     * @param size
     * @return
     */
    public static ThreadPoolExecutor getThreadExecutor(int size) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(size, 10, 30, TimeUnit.DAYS,
                new LinkedBlockingDeque<Runnable>(5), new ThreadFactory() {
            private final AtomicInteger atomicInteger = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "test-" + atomicInteger.incrementAndGet());
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("队列满啦，而且线程数量达到最大数量啦！");
                try {
                    executor.getQueue().put(r);
                    System.out.println("卡住了嘛？");
                } catch (Exception e) {
                    System.out.println("塞入队列异常啦！");
                }
                System.out.println("塞进队列成功！");
            }
        });
        return threadPoolExecutor;
    }

    public static void work() {
        try{
            System.out.println("线程: " + Thread.currentThread().getName() + "进来啦！");
            Thread.sleep(1000l);
        } catch (Exception e) {

        }
    }
}
