###synchronized 和lock 的区别
    1. 先从构成方面来看
        synchronized 是关键字属于JVM里面的
            monitorenter 底层是通过monitor对象来完成操作的
            monitorexit
        lock是个具体的类(java.util.concurrent.locks.Lock)
    2. 从使用层面来看
        synchronized 不需要自己手动释放锁，执行完后会自动让线程释放对锁的占用
        lock则需要自己手动释放锁，需要lock和unlock方法配合try/finally块来使用，如果不释放，可能会导致死锁发生
    3. 等待是否可以中断？
        synchronized 不可中断 除非异常或正常运行完成
        lock 可以随时中断，1.超时中断 trylock(long timeout,TimeUnit unit)
                        2.lockInterruptibly()放入代码块中，调用Interrupt()
    4. 加锁是否公平？
        synchronized非公平锁
        lock 是两个都可以，可以自主设置是否公平
    5.绑定多个条件的condition
        synchronized没有
        lock可以用来实现分组唤醒线程，可以精确唤醒，synchronized只能随机唤醒或者全部唤醒                    
            