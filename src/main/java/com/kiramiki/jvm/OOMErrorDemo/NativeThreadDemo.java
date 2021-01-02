package com.kiramiki.jvm.OOMErrorDemo;

/**
 * 高并发请求服务器常见异常
 *      java.lang.OutOfMemoryError: unable to create new native thread;
 *      准确的说，这个异常和对应的平台有关，
 *      你的应用开启的线程过多了，一个应用创建了多个线程超过系统承载的极限
 *      一般linux用户默认一个进程最多只能创建1024个线程，超过这个线程就会报这个异常
 *
 *      解决办法？
 *          降低应用程序创建的线程数量
 *          如果实在需要创建这么多线程，可以修改linux服务器的配置，扩大linux默认的限制
 */
public class NativeThreadDemo {
    /**
     * 放到linux环境下运行
     * @param args
     */
    public static void main(String[] args) {
        int i=0;
        while(true){
            System.out.println( "*********" + i);
            new Thread(()->{

            },String.valueOf(++i)).start();
        }
    }
}
