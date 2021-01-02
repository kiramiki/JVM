package com.kiramiki.jvm.OOMErrorDemo;

public class JavaHeapSpace {
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
