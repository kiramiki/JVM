package com.kiramiki.jvm.listDemo;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetDemo {
    public static void main(String[] args) {
//        HashSet<Object> set = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArraySet<String> set =new CopyOnWriteArraySet<String>();
//        ArrayList<String> arrayList  = new ArrayList<>();
        for(int i = 0 ; i <= 100; i++ ){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }).start();
        }
    }
}
