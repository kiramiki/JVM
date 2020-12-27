package com.kiramiki.jvm.jucCCSDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 刚好跟CountDownLatch相反，CountDownLatch做的是减法，CyclicBarrier是做的加法，
 * ---例如收集龙珠召唤神龙，必须七颗龙珠全部集齐才能召唤
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //第一个参数是总数，第二个参数是到达总数后开启的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for(int i = 1 ; i <= 7 ; i++ ){
            final int  temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 收集第" + temp + "个");
                try {
                    //当一个线程完毕后，必须等待其他线程一并返回。
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
