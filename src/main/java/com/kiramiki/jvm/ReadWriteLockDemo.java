package com.kiramiki.jvm;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * ---读-读是可以同步进行的
 * ---读-写 不能同时进行
 * ---写-写 不能同时进行
 */
public class ReadWriteLockDemo {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile Map<String,String> hashMap = new HashMap<>();
    public void set(String key,String value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写入");
            TimeUnit.MILLISECONDS.sleep(300);
            hashMap.put(key,value);
            System.out.println(Thread.currentThread().getName() + " 写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
    public void get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在读取");
            TimeUnit.MILLISECONDS.sleep(300);
            hashMap.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        for(int i = 0 ; i <= 5 ; i++ ){
            final int tempInt = i;
            new Thread(()->{
                readWriteLockDemo.set(tempInt + "" ,tempInt + "");
            },String.valueOf(i)).start();
        }

        for(int i = 0 ; i <= 5 ; i++ ){
            final int tempInt = i;
            new Thread(()->{
                readWriteLockDemo.get(tempInt + "");
            },String.valueOf(i)).start();
        }
    }
}
/**
 * 不加锁的输出结果
 *4 正在写入
 * 1 正在写入
 * 0 正在写入
 * 2 正在写入
 * 3 正在写入
 * 2 写入完成
 * 0 写入完成
 * 1 写入完成
 * 4 写入完成
 * 3 写入完成
 * 5 正在写入
 * 0 正在读取
 * 4 正在读取
 * 0 读取完成
 * 4 读取完成
 * 2 正在读取
 * 5 正在读取
 * 3 正在读取
 * 1 正在读取
 * 3 读取完成
 * 5 读取完成
 * 2 读取完成
 * 5 写入完成
 * 1 读取完成
 *
 * 读写锁
 * 1 正在写入
 * 1 写入完成
 * 2 正在写入
 * 2 写入完成
 * 0 正在写入
 * 0 写入完成
 * 5 正在写入
 * 5 写入完成
 * 3 正在写入
 * 3 写入完成
 * 4 正在写入
 * 4 写入完成
 * 0 正在读取
 * 1 正在读取
 * 2 正在读取
 * 3 正在读取
 * 4 正在读取
 * 5 正在读取
 * 0 读取完成
 * 5 读取完成
 * 4 读取完成
 * 1 读取完成
 * 2 读取完成
 * 3 读取完成
 *
 * Process finished with exit code 0
 * Process finished with exit code 0
 */