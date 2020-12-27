package com.kiramiki.jvm.lockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *  就是通过循环不断尝试获取锁，不会阻塞，但是如果一直获取不到锁，会拖慢CPU处理性能
 * 类似CAS的原理
 * 手写实现一个自选锁
 */
public class SpinLockDemo {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        //返回当前正在执行的线程对象
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " " + "myLock");
        //第一个进来的线程默认是null，通过cas返回的必定是ture，取反false则不会进入循环
        //第二个进来的线程如果第一个线程没有释放锁，那么那么会因为没有获取到锁进入循环中，不断尝试获取锁
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + " " + "myUnlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"t1").start();
        new Thread(()->{
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();

        },"t2").start();
    }
}
