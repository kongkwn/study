package com.tw.manual.example;

/**
 * @Author: tanwei
 * @Description:
 * @Date: Create in 14:39 2019/7/25
 *
 * 读写锁经典案例：https://blog.csdn.net/cdw8131197/article/details/52601559
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        final SynchronizedTest myt2 = new SynchronizedTest();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test2();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                myt2.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }

    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }
}
