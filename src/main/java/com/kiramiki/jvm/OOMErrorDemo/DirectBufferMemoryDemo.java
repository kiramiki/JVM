package com.kiramiki.jvm.OOMErrorDemo;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * 配置参数
 *  -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *故障现象
 *  Exception in thread "main" java.lang.OutOfMemoryError: Cannot reserve 6291456 bytes of direct buffer memory (allocated: 8192, limit: 5242880)erve 6291456 bytes of direct buffer memory
 *导致原因
 *  NIO程序经常要使用ByteBuffer来读取或者写入数据，这是一种基于通道和缓冲区的的I/o方式
 *  它可以使用native函数库直接分配堆外内存，然后通过一个存储在java堆里面的DirectByteBuffer对象来对这块内存进行操作
 *  ByteBuffer.allocate(capability) 分配java堆内存，属于GC范畴 所以速度相对较慢
 *  ByteBuffer.allocateDirect(capability) 分配到OS本地内存，不属于GC范畴 ，因为不需要内存copy所以速度相对较快
 *
 *  如果不断分配本地内存，堆内存使用很少，JVM就不需要执行GC DirectByteBuffer对象不会被回收
 *  这时候如果堆内存充足，但是本地内存可能已经被使用光了，再尝试分配本地内存就会出现这个异常，程序会直接崩溃
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer bb = ByteBuffer.allocateDirect( 6 * 1024 * 1024);
    }
}
