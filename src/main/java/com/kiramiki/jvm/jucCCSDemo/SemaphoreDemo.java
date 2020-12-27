package com.kiramiki.jvm.jucCCSDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 作用是模拟线程资源总数，限制线程频繁抢占资源，可以应用于秒杀等多个业务场景
 * ---例如抢车位
 * ------6辆车抢3个车位
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //模拟资源数为3 ---三个车位
        Semaphore semaphore = new Semaphore(3);

        for(int i = 1 ; i <= 6 ; i++ ){
            new Thread(()->{
                try {
                    //表示每进来一个线程需要消耗一个资源 ---来一辆车消耗一个车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    //模拟车位停三秒后离开
                    TimeUnit.SECONDS.sleep(3);
                    //释放车位
                    System.out.println(Thread.currentThread().getName() + "\t释放车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //线程处理结束后需要释放资源
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
