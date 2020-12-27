package com.kiramiki.jvm.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 第四种使用线程的方式,线程池~
 *  线程池常用的主要是有5种
 *  常用的为3种
 *  1.2 七大参数
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        try{
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
}
