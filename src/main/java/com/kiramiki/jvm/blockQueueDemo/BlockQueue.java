package com.kiramiki.jvm.blockQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * 1.1 阻塞队列？ 是什么？
 *      阻塞队列相当于在默认队列会阻塞的情况下，会进行一系列的处理
 *      比如当队列为空时，阻止目标向队列中获取元素
 *         当队列满时，组织目标向队列中插入元素
 * 1.2阻塞队列有多少种?
 *  常见的阻塞队列主要有7种，
 *      ArrayBlockingQueue
 *      LinkedBlockingQueue
 *      SynchronousQueue
 */
public class BlockQueue {
    /**
     * 第一组会直接抛出异常
     *  add remove element
     * @param args
     */
    public static void main2(String[] args) {
        //长度为3的阻塞队列
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        //当添加第四个元素时，因为队列已满，阻塞队列会直接抛出异常
        //java.lang.IllegalStateException: Queue full
//        System.out.println(arrayBlockingQueue.add("x"));
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        //当删除第四个元素时，队列为空，会直接抛出异常
        //java.util.NoSuchElementException
        System.out.println(arrayBlockingQueue.remove());
    }
    public static void main3(String[] args) {
        /**
         * 第二组会返回布尔类型的值
         * offer  poll peek
         */
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("a"));
        //当添加第四个元素时，因为队列已满，阻塞队列会直接返回false ，插入失败
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        //当删除/查看第四个元素时，队列为空，阻塞队列会直接返回null,没有这个元素
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.poll());
    }

    /**
     * 第三种会一直阻塞，直到成功位置
     *  put 、 take
     * @param args
     * @throws InterruptedException
     */
    public static void main1(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
//        arrayBlockingQueue.put("a");
//        arrayBlockingQueue.put("a");
//        arrayBlockingQueue.put("a");
        //当插入第四个元素时，因为队列已满，put方法会一直等待，等待能插入进去即可 -----慎用
//        arrayBlockingQueue.put("a");
        //移除元素时，如果队列为空，阻塞队列会一直阻塞,直到插入第四个元素
        arrayBlockingQueue.take();
    }

    /**
     * 第四种超时返回
     * 设置一个超时时间，时间结束会直接返回失败
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        //当插入第四个元素时，因为队列已满，offer，等待2s，期间不断重试，过时插入失败返回false
        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        //移除元素时，如果队列为空，等待2s,期间不断重试，过时插入失败返回false
        System.out.println(arrayBlockingQueue.poll(2L, TimeUnit.SECONDS));
    }
}
