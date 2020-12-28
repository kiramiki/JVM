package com.kiramiki.jvm.referenceDemo;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<Integer,String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "weakHashMap";
        weakHashMap.put(1,value);
        System.out.println(weakHashMap);
        key = null;
        System.out.println(weakHashMap);
        System.out.println("******************");
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(5);
            System.gc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(weakHashMap);
    }
}
