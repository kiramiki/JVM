package com.kiramiki.jvm.lockDemoTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParallelStreamsDemo {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(100);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
           hashMap.put(i + "" , i + "");
            list.add(i+"");
        }

       list.parallelStream().forEach((data)->{
       });
    }
}
