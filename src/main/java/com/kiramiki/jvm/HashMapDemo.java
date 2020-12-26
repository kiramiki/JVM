package com.kiramiki.jvm;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapDemo {
    public static void main(String[] args) {

//        HashSet<Object> set = Collections.synchronizedList(new ArrayList<>());
        ConcurrentHashMap<String, String> map =new ConcurrentHashMap<String,String>();
//        ArrayList<String> arrayList  = new ArrayList<>();
        for(int i = 0 ; i <= 100; i++ ){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }).start();
        }
    }
}
