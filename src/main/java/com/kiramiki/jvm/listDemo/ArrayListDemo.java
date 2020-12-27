package com.kiramiki.jvm.listDemo;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 如何解决ArrayList线程不安全
 */
public class ArrayListDemo {
    public static void main(String[] args) {
//        List<Object> arrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> arrayList =new CopyOnWriteArrayList<>();
//        ArrayList<String> arrayList  = new ArrayList<>();
        for(int i = 0 ; i <= 100; i++ ){
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(arrayList);
            }).start();
        }

        /**
         * 1.故障现象
         * ConcurrentModificationException 异常
         * 2.出现原因？
         *  高并发线程访问下ArrayList线程不安全，导致并发修改异常出现
         *      一个线程正在修改，另一个线程进入争抢修改，导致此异常发生
         * 3.如何解决
         *  3.1 vector集合类(不建议)
         *  3.2 Collections.synchronizedList
         *  3.3 JUC的CopyOnWriteArrayList
         *      3.3.1 写时复制
         *      public boolean add(E e) {
         *         synchronized (lock) {
         *             Object[] es = getArray();
         *             int len = es.length;
         *             es = Arrays.copyOf(es, len + 1);
         *             es[len] = e;
         *             setArray(es);
         *             return true;
         *         }
         *     }
         * 4.优化方案
         */
    }
}
