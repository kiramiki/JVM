package com.kiramiki.jvm.OOMErrorDemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * GC GC Overhead limit exceeded
 *  当系统中大量内存被用来回收却又回收效果不明显时，会出现这个异常
 *      98%内存用来回收，回收的空间却不足2%
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("***************" + i);
            e.printStackTrace();
            throw e;
        }

    }
}
