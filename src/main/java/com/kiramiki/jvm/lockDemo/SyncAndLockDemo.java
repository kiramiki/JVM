package com.kiramiki.jvm.lockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   题目 多线程之间按顺序调用，实现A->B->C三个线程启动
 *   按顺序循环打印 AA 5次 BB 10次 CC15次
 *   打印10轮
 * 开启线程第一步，线程调用资源类
 * 资源类
 */
class Number{
    private int number = 1; //aa bb cc
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public Condition getC(int num){
        if ( num == 1) {
            return c1;
        }
        if ( num == 2 ){
            return c2;
        }
        return c3;
    }
    public Condition getCd(int num){
        if ( num == 1) {
            number = 2;
            return c2;
        }
        if ( num == 2 ){
            number = 3;
            return c3;
        }
        number = 1;
        return c1;
    }
    public void print(Integer count, Integer num) {
        lock.lock();
        try{
            //判断 1   1
            while ( number != num){
                getC(num).await();
            }
            //执行
            for ( int i = 0; i < count ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            //通知
            getCd(num).signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print5(Integer count, Integer num) {
        lock.lock();
        try{
            //判断 1   1
            while ( number != 1){
                c1.await();
            }
            //执行
            for ( int i = 0; i < count ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            //通知
                number = 2;
                c2.signal();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print10(Integer count, Integer num) {
        lock.lock();
        try{
            //判断 1   1
            while ( number != 2){
                c2.await();
            }
            //执行
            for ( int i = 0; i < count ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            //通知
            number = 3;
            c3.signal();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print15(Integer count, Integer num) {
        lock.lock();
        try{
            while ( number != 3){
                c3.await();
            }
            //执行
            for ( int i = 0; i < count ; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + number);
            }
            number = 1;
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
/**
 * 题目 多线程之间按顺序调用，实现A->B->C三个线程启动
 * 按顺序循环打印 AA 5次 BB 10次 CC15次
 * 打印10轮
 */
public class SyncAndLockDemo {
    public static void main(String[] args) {
        Number number = new Number();
//        new Thread(()->{
//            for(int i = 1 ; i <= 10 ; i++ ){
//                number.print5(5,1);
//            }
//        }, "AA").start();
//        new Thread(()->{
//            for(int i = 1 ; i <= 10 ; i++ ){
//                number.print10(10,2);
//            }
//        }, "BB").start();
//        new Thread(()->{
//            for(int i = 1 ; i <= 10 ; i++ ){
//                number.print15(15,3);
//            }
//        }, "CC").start();
        new Thread(()->{
            for(int i = 1 ; i <= 10 ; i++ ){
                number.print(5,1);
            }
        }, "AA").start();
        new Thread(()->{
            for(int i = 1 ; i <= 10 ; i++ ){
                number.print(10,2);
            }
        }, "BB").start();
        new Thread(()->{
            for(int i = 1 ; i <= 10 ; i++ ){
                number.print(15,3);
            }
        }, "CC").start();
    }
}
