package com.kiramiki.jvm.lockDemo;

import java.util.concurrent.TimeUnit;

class MyResource implements Runnable{

    String lockA ;
    String lockB ;

    public MyResource(String  lockA, String  lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        System.out.println("lockA = " + lockA);
        System.out.println("lockB = " + lockB);
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"自己持有-----"+ lockA + "尝试获得" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"自己持有-----"+ lockB + "尝试获得" + lockA);
            }
        }
    }
}
public class DeadLockDemo {
    /**
     * 如何确定故障的原因是死锁？
     *  jps 和jstack
     *      命令行输入jps -l 查看java项目进程
     *          D:\kiramiki\JVM>jps -l
     *          12324 org.jetbrains.jps.cmdline.Launcher
     *          16632
     *          14588 com.kiramiki.jvm.lockDemo.DeadLockDemo
     *          7836 jdk.jcmd/sun.tools.jps.Jps
     *
     *      确定异常类 输入jstack ’port‘ 查看故障原因
     *
     * "AAA":
     *         at com.kiramiki.jvm.lockDemo.MyResource.run(DeadLockDemo.java:27)
     *         - waiting to lock <0x0000000710872bf0> (a java.lang.String)
     *         - locked <0x0000000710872bc0> (a java.lang.String)
     *         at java.lang.Thread.run(java.base@15.0.1/Thread.java:832)
     * "BBB":
     *         at com.kiramiki.jvm.lockDemo.MyResource.run(DeadLockDemo.java:27)
     *         - waiting to lock <0x0000000710872bc0> (a java.lang.String)
     *         - locked <0x0000000710872bf0> (a java.lang.String)
     *         at java.lang.Thread.run(java.base@15.0.1/Thread.java:832)
     *
     * Found 1 deadlock.
     */
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyResource(lockA,lockB),"AAA").start();
        new Thread(new MyResource(lockB,lockA),"BBB").start();
    }
}
