package com.kiramiki.jvm.referenceDemo;

import java.lang.ref.SoftReference;

/**
 * 强引用
 *      一律不会回收，就算发生OOM也不会回收
 * 软引用
 *      内存够用则不回收，内存不够则会回收
 * 弱引用
 *      不管够不够用，都会回收，一次性对象
 *
 *      什么时候用软引用和弱引用呢？
 *          假设有一个场景，需要取大量图片
 *              直接从硬盘取会严重影响性能
 *              从内存取又可能造成内存溢出
 *              这时使用软引用能够解决问题
 *                  设计思路就是用hashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，在内存不足时，JVM会自动回收掉这些缓存图片对象所占的内存空间
 *                  Map<String,SoftReference<BitMap>> imageCache = new HashMap<String,SoftReference<BitMap>>();
 * 虚引用
 *
 *
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        System.gc();
        System.out.println("``````````````````````");
        byte[] a = new byte[30*1024*1024];
        System.out.println(o);
        System.out.println(softReference.get());

    }
}
