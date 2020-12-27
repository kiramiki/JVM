package com.kiramiki.jvm.casDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    public static AtomicInteger atomicInteger = new AtomicInteger(100);
    public static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("ABA问题产生========================");
        new Thread(()->{
            boolean b = atomicInteger.compareAndSet(100, 101);
            System.out.println( b + " " + atomicInteger.get());
            boolean b1 = atomicInteger.compareAndSet(101, 100);
            System.out.println(b1 + " " + atomicInteger.get());
        },"t1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicInteger.compareAndSet(100, 2019);
            System.out.println( b + " " + atomicInteger.get());
        },"t2").start();
        System.out.println(atomicInteger.get());


        System.out.println("ABA问题解决========================");
        new Thread(()->{
            int Stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一次版本号:" + atomicStampedReference.getStamp() );
            atomicStampedReference.compareAndSet(100,101,Stamp,atomicStampedReference.getStamp()+1);
            System.out.println("第二次版本号:" + atomicStampedReference.getStamp() +" "+ atomicStampedReference.getReference());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("第三次版本号:" + atomicStampedReference.getStamp() +" "+ atomicStampedReference.getReference());
        },"t3").start();

        new Thread(()->{
            int Stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,2019,Stamp,atomicStampedReference.getStamp()+1);
            System.out.println("第四次版本号:" + atomicStampedReference.getStamp() +" " + atomicStampedReference.getReference());
        },"t4").start();
    }
}
