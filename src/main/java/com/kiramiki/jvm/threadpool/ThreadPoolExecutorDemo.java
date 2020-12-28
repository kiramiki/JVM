package com.kiramiki.jvm.threadpool;

import java.util.concurrent.*;

/**
 * 第四种使用线程的方式,线程池~
 *  线程池常用的主要是有5种
 *  常用的为3种
 *  1.1 工作中一般用那种线程池？
 *      因为默认的阻塞队列大小是Integer.max 默认是最大数量的大小。当高并发业务下来后，会无限往阻塞队列中塞线程，如果超过内存大小，会直接爆OOM异常
 *      所以一般我们选择自定义线程池
 *  1.2 七大参数
 *      核心工作线程数
 *      最大工作线程数
 *      拒绝策略触发后响应时间
 *      响应时间单位
 *
 *      拒绝策略
 *  1.3 常用的四种拒绝策略
 *      ThreadPoolExecutor.AbortPolicy() 超出允许上限直接抛出异常 上限计算为maximumPoolSize +阻塞队列大小
 *      ThreadPoolExecutor.CallerRunsPolicy() 将触发拒绝策略的线程抛回给自己去处理 这里因为是main掉用，因此抛回给main去处理
 *      ThreadPoolExecutor.DiscardOldestPolicy() 将处理时间最长的线程直接舍弃
 *      ThreadPoolExecutor.DiscardPolicy()  直接将超过的线程丢弃
 *  1.4 生产中如何配置maximumPoolSize？
 *      主要有2种方式
 *          第一种为CPU密集型，根据CPU内核数量来配
 *          第二种为IO密集型，a. CPU * 2
 *                         b. CPU/(1-0.8 or 1-0.9)
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //得到cpu内核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try{
            //模拟用户来办理业务，每一个用户就是一个请求
            for (int i = 0;i< 10 ;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t ***");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
        ExecutorService threadPool01 = Executors.newFixedThreadPool(5);
////        ExecutorService threadPool = Executors.newSingleThreadExecutor();
////        ExecutorService threadPool = Executors.newCachedThreadPool()；
}
