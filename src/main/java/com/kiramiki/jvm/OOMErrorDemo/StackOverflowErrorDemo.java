package com.kiramiki.jvm.OOMErrorDemo;

public class StackOverflowErrorDemo {
    public static void main(String[] args) {
//        stackOverflowError();
//        javaHeapSpace();
    }

    /**
     * 栈溢出异常
     *  故障原因，方法深度调用会导致这个异常
     * Exception in thread "main" java.lang.StackOverflowError
     * at com.kiramiki.jvm.OOMErrorDemo.StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:9)
     */
    private static void stackOverflowError() {
        stackOverflowError();
    }

    /**
     * 堆溢出
     *  故障原因，对象过多会导致堆溢出
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at com.kiramiki.jvm.OOMErrorDemo.StackOverflowErrorDemo.javaHeapSpace(StackOverflowErrorDemo.java:19)
     */
    private static void javaHeapSpace() {
        byte[] b = new byte[50*1024*1024];
    }

}
