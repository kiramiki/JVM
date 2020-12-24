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
    public void dataPlusPlus(){
        data++;
    }
}

/**
 * 1.0验证volatile的可见性
 * 假设data = 0；如果没有加volatile内存不可见将会进入死循环
 * 1.1volatile不保证原子性案例演示
 * 为什么不保证原子性呢？主要是在线程还没有读到主内存修改后的值，就已经进行了修改操作，也就是当线程1 将a = 1 变成 a=2后，通知给主内存，而线程二可能因为还没有唤醒或者其他等的原因，保存的还是a=1 的值，因此返回给主线程的也是a=2;
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyData myData= new MyData();
        for(int i = 1 ; i <= 20 ; i ++){
            new Thread(()-> {
                for (int j = 1 ; j <= 1000 ; j++){
                    myData.dataPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t  data = " + myData.data );
    }
//    public static void main(String[] args) {
//        MyData myData = new MyData();
//        //开启第一个线程
//        new Thread(()-> {
//            System.out.println(Thread.currentThread().getName()+ "\t come in");
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            myData.SetDataTo60();
//            System.out.println(Thread.currentThread().getName() + "\t update number value " + myData.data);
//        }, "AAA").start();
//        //main线程为第二个线程
//        while (myData.data == 0 ){
//            //在此一直循环，直到number不等于0
//            //如果主内存不可见，结果就是while == 0 进入死循环
//        }
////        System.out.println(Thread.currentThread().getName() + "\t mission is over");
//        System.out.println(Thread.currentThread().getName() + "\t main volatile " + myData.data  );
//    }
}
