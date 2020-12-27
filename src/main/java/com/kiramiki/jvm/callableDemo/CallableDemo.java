package com.kiramiki.jvm.callableDemo;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 带返回值的线程实现
 *  什么时候需要使用?
 *      1. 需要返回带返回值的线程时候可以使用
 *      2. 如果有一个线程步骤比较耗时,可以使用Callable处理这个线程,单独拿出来计算,最后合并,
 */
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }

}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"aa").start();
        System.out.println(Thread.currentThread().getName()+"****");
        Integer i = 1213;
        //比较耗时的线程尽量放在最后也可以使用while循环的方法,不过不推荐,建议直接放最后
        int j = futureTask.get();
//        while(!futureTask.isDone()){
//
//        }
        System.out.println(i+j);
    }
}
