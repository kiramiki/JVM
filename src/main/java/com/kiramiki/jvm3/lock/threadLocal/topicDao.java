package com.kiramiki.jvm3.lock.threadLocal;

import com.kiramiki.calendar.Perpetual;

import java.util.concurrent.TimeUnit;

/**
 * @ Author ：zl.
 * @ Date ：Created in 14:51 2022/7/22
 * @ Description ：threadLocal
 * https://www.jianshu.com/p/6fc3bba12f38
 * https://blog.csdn.net/qq120631157/article/details/122079250
 *
 * spring事务中有用到threadLocal
 * 我们都知道spring的事务是通过AOP方式创建一个用来处理事务的beanPorcessor，在方法的前置通知执行事务的操作，
 * 前置通知中核心的方法是invokeWithinTransaction方法，在里面他会创建一个transactionInfo对象，保存的是事务的状态和属性信息
 * 而这个对象就是通过调用bindToThread()方法，创建一个localThread<TransactionInfo>，将事务的信息放在localThread中,来确保事务之间使用的都是变量的copy
 *
 */
public class topicDao {
        private static ThreadLocal<Perpetual> thread = new ThreadLocal<>();

        public static Perpetual getPer(){
                thread.set(new Perpetual());
                return thread.get();
        }

        public static void addTopic(int x){
                int stat = getPer().getWeek();
                stat = stat + x;
                System.out.println(Thread.currentThread().getName() + " " + stat);
        }

        public static void main(String[] args) {
                new Thread(()->{
                     addTopic(5);
                },"A").start();
                new Thread(()->{
                        try {
                                TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        addTopic(6);
                },"B").start();
                new Thread(()->{
                        try {
                                TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        addTopic(7);
                },"C").start();
        }
}
/**
 * ThreadLocal使用实例
 * ThreadLocal为解决多线程程序的并发问题提供了一种新的思路。使用这个工具类可以很简洁地编写出优美的多线程程序，
 *
 * ThreadLocal并不是一个Thread，而是Thread的局部变量。
 * ThreadLocal是解决线程安全问题一个很好的思路，
 * 它通过为每个线程提供一个独立的变量副本解决了变量并发访问的冲突问题。
 * 在很多情况下，ThreadLocal比直接使用synchronized同步机制解决线程安全问题更简单，更方便，且结果程序拥有更高的并发性。
 * ThreadLocal类接口很简单，只有4个方法，我们先来了解一下：
 *
 * Object get()：获取该线程局部变量的值。
 * void set(Object value)：给该线程局部变量赋值。
 * protected Object initialValue()：返回该线程局部变量的初始值，该方法是一个protected的方法，
 * 显然是为了让子类覆盖而设计的。
 * public void remove()：将当前线程局部变量的值删除。
 */
