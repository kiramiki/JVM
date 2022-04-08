package com.kiramiki.jvm.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {
    private ExecutorService executor = Executors.newCachedThreadPool() ;

    public void fun() throws Exception {
        executor.submit(new Runnable(){
            @Override
            public void run() {
                try {
                    //要执行的业务代码，我们这里没有写方法，可以让线程休息几秒进行测试
                    Thread.sleep(10000);
                    System.out.print("睡够啦~");
                }catch(Exception e) {
                    throw new RuntimeException("报错啦！！");
                }
            }
        });
    }
}
