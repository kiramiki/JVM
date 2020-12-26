package com.kiramiki.jvm;

import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs= new User("zs","25");
        User ls= new User("ls","25");
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zs);
        boolean a = atomicReference.compareAndSet(zs,ls);
        boolean b = atomicReference.compareAndSet(zs,ls);
        System.out.println(a + " " + Thread.currentThread().getName() + "\t" + atomicReference.get().toString());
        System.out.println(b + " " + Thread.currentThread().getName() + "\t" + atomicReference.get().toString());
    }
}
