package com.kiramiki.jvm3.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AbstractQueuedSynchronizer源码分析
 *
 */
public class AQSDemo {
    /**
     *反复：
     *先检查节点是否
     *如果是这样，确保头部稳定，否则确保有效的前置任务
     *如果节点是第一个或尚未排队，请尝试获取
     *否则，如果节点尚未创建，请创建它
     *否则，如果尚未排队，请尝试排队一次
     *否则，如果从驻车档唤醒，请重试（最多后旋次数）
     *否则，如果未设置等待状态，请设置并重试
     *否则停车并清除等待状态，并检查取消
     */
    /**
     * 可能会从尾部重复遍历，取消对已取消节点的显示，直到找不到任何节点为止。对可能已重新链接为下一个合格收单机构的节点进行解压
     * @param args
     */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        int postSpins = 0;
        postSpins =  (byte)((postSpins << 1) | 1);
        System.out.println(postSpins);
    }
}
