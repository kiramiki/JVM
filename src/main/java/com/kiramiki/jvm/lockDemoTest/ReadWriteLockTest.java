package com.kiramiki.jvm.lockDemoTest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile HashMap<String,String> hashMap = new HashMap<>();
    private void set(String key,String value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  正在写入");
            hashMap.put(key,value);
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName() + "  写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  正在读取 ");
            hashMap.get(key);
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName() + "  读取完成 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }


    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        for (int i = 0 ; i < 10 ; i++){
            final int finalI = i;
            new Thread(()->{
                readWriteLockTest.set(finalI + "",finalI + "");
            },String.valueOf(i)).start();
        }

        for (int i = 0 ; i < 10 ; i++){
            final int finalI = i;
            new Thread(()->{
                readWriteLockTest.get(finalI + "");
            },String.valueOf(i)).start();
        }
    }
}
