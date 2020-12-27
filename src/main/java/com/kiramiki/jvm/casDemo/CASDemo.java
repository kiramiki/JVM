package com.kiramiki.jvm.casDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas 是什么？
 * CompareAndSet(比较并交换)
 * 下例所示
 * ---放入主物理内存的值为5
 * ---这时来了第一个线程，使用compareAndSet方法，期望值为5，更改值为2019，意思就是在这个线程工作期间，如果期望值是5，表示这个值没有被其他线程
 * ---修改过，此时期望值和实际值相等，因此将进行更新操作，将值改为2019
 */
public class CASDemo {
    /**
     * CAS底层原理
     * CAS底层原理实现是rt.jar下面的unsafe.class这个类
     * 他里面有一个getAndADDInt方法，方法通过循环重复的将实际值和期望值进行比较，如果返回的是false就继续循环，直至true结束循环，
     * 因为底层是用的是汇编语言的原语进行操作，原语的操作是单线程的，因此保证了CAS的同步机制
     * @param args
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019) +" " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2019) +" " + atomicInteger.get());
        /**
         * CAS的缺点？
         *  1.如果cas一直比较失败，一直陷入自旋锁，可能会给CPU带来很大的开销
         *  2.CAS只能操作一个变量，对于过个变量无法处理
         *  3. 无法解决ABA问题
         *      ABA问题是什么？
         *          假如X线程和Y线程读取主物理内存的值A将其copy进自己的变量副本，由于线程Y的处理效率很快，他将A改成了B，然后又改成了A，当X线程
         *          操作时，会发现期望值和实际值相等，认为这个数据没有被动过。
         */
        atomicInteger.getAndIncrement();

    }
    /**
     * valueOfset表示对象引用地址
     */
//    public final int getAndIncrement() {
//        return unsafe.getAndAddInt(this, valueOffset, 1);
//    }


       //第一个参数var1是期望值，第二个参数var2是引用地址，第三个var4是增加数值
//    public final int getAndAddInt(Object var1, long var2, int var4) {
//        int var5;
//        do {
             //通过getIntVolatile方法，因为保证了可见性，得到实际值var5
//            var5 = this.getIntVolatile(var1, var2);
                //将期望值和实际值进行比对，如果相同则将update，否则继续得到var5
//        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
//
//        return var5;
//    }
}
