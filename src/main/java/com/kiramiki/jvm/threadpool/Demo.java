package com.kiramiki.jvm.threadpool;

public class Demo {
    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor();
        try {
                myExecutor.fun();
            System.out.print("你先睡着,我先回家啦~");
        }catch(Exception e) {
            throw new RuntimeException("业务程序报错啦！！");
        }

    }
}
