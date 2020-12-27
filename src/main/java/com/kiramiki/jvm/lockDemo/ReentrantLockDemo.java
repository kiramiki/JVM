package com.kiramiki.jvm;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Person implements  Runnable{
    ReentrantLock lock = new ReentrantLock();
    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName() + "\t" + "000");
        sendEmail();
    }
    public  synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName() + "\t" + "000");
    }

    @Override
    public void run() {
        get();
    }

    /**
     *如果写多个lock，必须要有多个unlock配对，缺一个unlock不会报错，但是运行时会无法释放锁，导致程序不会中断
     */
    public void get(){
        lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t" + "get");
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t" + "set");
        }finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {
    /**
     * 可重入锁，也就是递归锁
     *  意思就是如果最外层方法有加可重入锁，此方法内部的所调用的其他方法如果也拥有锁，那么该线程会自动拥有全部锁
     *  synchronized和ReentrantLock 都是可重入锁
     */
    public static void main(String[] args) {

        Person person = new Person();
        new Thread(()->{
            person.sendSms();
        },"t1").start();
        new Thread(()->{
            person.sendSms();
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        Thread thread03 = new Thread(person,"t3");
        Thread thread04 = new Thread(person,"t4");
        thread03.start();
        thread04.start();



        /**
         * 公平锁和非公平锁，默认使用的是非公平锁
         * synchronized默认也是非公平锁
         */
//        ReentrantLock lock = new ReentrantLock(false);
    }
}
