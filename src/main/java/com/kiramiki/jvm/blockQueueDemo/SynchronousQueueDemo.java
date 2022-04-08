package com.kiramiki.jvm.blockQueueDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue 队列中只允许有一个元素，这个元素必须被消费才能插入
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + " put");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + " put");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + " put");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ccc").start();

        new Thread(() -> {
            try {
                System.out.println(blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "bbb").start();
    }
}
