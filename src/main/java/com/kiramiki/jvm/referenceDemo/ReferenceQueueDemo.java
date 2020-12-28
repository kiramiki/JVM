package com.kiramiki.jvm.referenceDemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 一般对象在被GC回收前，会先将对象放入到引用队列中，如果在这个期间该对象重新获得引用，则可以继续使用
 * System.gc()只是建议JVM进行回收。并不能强制操作JVM垃圾回收器
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        /**
         * java.lang.Object@16b98e56
         * null
         * null
         * ------------------------
         * null
         * null
         * java.lang.ref.PhantomReference@7ef20235
         */
        Object o = new  Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o,referenceQueue);
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("------------------------");
        o = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
    /**
     *
     * java.lang.Object@16b98e56
     * java.lang.Object@16b98e56
     * null
     * ------------------------
     * null
     * null
     * java.lang.ref.WeakReference@7ef20235
     *
     * @param args
     */
    public static void MyweakReference(String[] args) {
        Object o = new  Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o,referenceQueue);
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("------------------------");
        o = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }
}
