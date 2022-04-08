package com.kiramiki.jvm3.lock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class SyncDemo {
    static Object o = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    /**
     * lockSupport的park和unpark方法作用跟wait和notify一样，但是他的使用非常方便，第一是他不需要在锁内使用，第二是他的顺序是可以先unpark在park的。
     *  为什么顺序可以相反？
     *      因为lockSupport底层有一个机制是许可证机制，当你持有许可证时，才允许放行，否则就会被阻塞，每当执行park方法时，都会消耗许可证
     *      而unpark方法会发放许可证，但是许可证他的最大容量只能是1，这也就说明了，当你多次调用unpark时，不会增加许可证，此时如果你的park有多个，但是只会有一个park拿到许可证，其他都会被阻塞
     *      他的底层调用时Unsafe.park()和Unsafe.unpark()
     * @param args
     */
    public static void lockSupport(String[] args) {
        Thread a = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " A");
            LockSupport.park();
            System.out.println("A 被唤醒");
        },"A");
        a.start();
        Thread b = new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " B唤醒");
            LockSupport.unpark(a);
        },"B");
        b.start();
    }
    /**
     * 和wait和notify一样，必须配合lock使用，signal必须在await之前
     * @param args
     */
    public static void awaitAndSignal(String[] args) {
        new Thread(()->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " A");
                condition.await();
                System.out.println("A 被唤醒");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"A").start();
        new Thread(()->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " B唤醒");
                condition.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"B").start();
    }
    /**
     * 传统的wait和notify
     *  必须放在synchronized内部使用，且必须wait在notify前面，否则则会出错，
     * @param args
     */
    public static void waitAndNotify(String[] args) {

        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName() + " A");
                try {
                    o.wait();
                    System.out.println("A被唤醒");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName() + " B唤醒");
                try {
                    o.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
