package com.kiramiki.jvm.providerAndCustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class ShareData{
    private int number = 0;
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void numberAdd(){
        lock.lock();
        try{
            while(number != 0){
                //等待，不能继续生产
                condition.await();
            }
            //生产
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class ProdCustomer_TraditionDemo {
}
