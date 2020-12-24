package com.kiramiki.jvm;


import java.util.concurrent.TimeUnit;

/**
 * JMM 内存模型（虚拟叫法，实际并不存在）
 * 内存模型保证了java的可见性，原子性和有序性
 * 可见性指当多个线程修改同一数据时，如果内存可见，在一个线程修改后，会通知主内存，主内存会通知其他线程，相对于其他线程而言，变量的修改是可见的(各个线程之间得到的变量是主内存的copy)
 */
class MyData{
    volatile Integer data = 0;
    public void SetDataTo60(){
        this.data = 60;
    }
}

/**
 * 验证volatile的可见性
 * 假设data = 0；如果没有加volatile内存不可见将会进入死循环
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyData myData = new MyData();
        //开启第一个线程
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+ "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            myData.SetDataTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value " + myData.data);
        }, "AAA").start();
        //main线程为第二个线程
        while (myData.data == 0 ){
            //在此一直循环，直到number不等于0
            //如果主内存不可见，结果就是while == 0 进入死循环
        }
//        System.out.println(Thread.currentThread().getName() + "\t mission is over");
        System.out.println(Thread.currentThread().getName() + "\t main volatile " + myData.data  );
    }
}
