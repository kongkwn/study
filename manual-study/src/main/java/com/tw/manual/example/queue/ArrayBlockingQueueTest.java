package com.tw.manual.example.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: tanwei
 * @Description: ArrayBlockingQueue BlockingQueue接口的实现类，阻塞的插入 移除方法 put take,非阻塞offer,poll也可以用，有返回值，不过会出现队列满了就丢弃元素的情况
 * @Date: Create in 11:10 2019/8/8
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws Exception{
        BlockingQueue queue =new ArrayBlockingQueue(1024);
        Product product =new Product(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(product).start();
        new Thread((consumer)).start();
        Thread.sleep(4000);
    }
}

class Product implements Runnable{

    protected BlockingQueue queue = null;

    Product (BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            System.out.println("put"+1);
            Thread.sleep(1000);
            queue.put("2");
            System.out.println("put"+2);
            Thread.sleep(1000);
            queue.put("3");
            System.out.println("put"+3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    Consumer (BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            System.out.println("take"+queue.take());
            System.out.println("take"+queue.take());
            System.out.println("take"+queue.take());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}