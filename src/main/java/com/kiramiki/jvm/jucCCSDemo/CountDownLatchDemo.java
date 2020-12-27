package com.kiramiki.jvm.jucCCSDemo;

import com.kiramiki.jvm.utils.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 主要的作用就是给线程一个计数，保证一些线程执行完毕后，才允许其他线程执行
 * 例如生活中的放学锁门，必须要等其他同学全部出门后才能锁门，此时用线程模拟每一个同学出门，如果不加CountDownLatch则会发生错误，
 * 又例如秦统一6国，必须要先全灭了才能统一。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //创建一个countDownLatch对象，大小为6，表示只有当6次全部结束后，才允许其他线程访问
        CountDownLatch countDownLatch = new CountDownLatch(6);
       for(int i = 1 ; i <= 6 ; i++ ){
           new Thread(()->{
               System.out.println(Thread.currentThread().getName() + "\t" + "国");
               //计数减一
               countDownLatch.countDown();
           }, CountryEnum.for_CountryEnum(i).getCountry()).start();
       }
        try {
            //等待技术为0才能执行主线程
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t" + "秦国一统");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Thread.currentThread().getName() + "\t" + "秦国一统");
    }
}
