package com.kiramiki.jvm.providerAndCustomer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 资源类
 */
class MyResource{
    //设置成volatile意义是保证flag是对所有线程可见的,当他变为false时,应该是被所有线程可见的
    private volatile boolean flag = true;
    BlockingQueue<String> blockingQueue = null;
    AtomicInteger atomicInteger = new AtomicInteger(3);

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    /**
     * 生产者
     */
    public void getProd() throws InterruptedException {
        String data = null;
        boolean retValue;
        while(flag){
            //CAS保证数据的同步
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t插入成功" + data);
            }else{
                System.out.println(Thread.currentThread().getName() + "\t插入失败" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t老板叫停");
    }

    /**
     * 消费者
     * @throws InterruptedException
     */
    public void getCustomer() throws InterruptedException {
        String result;
        while(flag){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result ==null || result.equalsIgnoreCase("")){
                System.out.println(Thread.currentThread().getName() + "\t取出失败" + result);
                flag =false;
            }else{
                System.out.println(Thread.currentThread().getName() + "\t取出成功" + result);
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    public void stop(){
        flag = false;
    }
}

/**
 * 阻塞队列实现的生产者消费者模式
 */
public class ProdCustomerDemo {
    public static void main(String[] args) {
        //传一个任意类型的阻塞队列
        MyResource myResource = new MyResource( new ArrayBlockingQueue<>(10));
        //启动生产者和消费者
        new Thread(()->{
            try {
                myResource.getProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            try {
                myResource.getCustomer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"customer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myResource.stop();
    }
}
