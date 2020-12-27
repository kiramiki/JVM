package com.kiramiki.jvm.volatileDemo;

public class SingletonDemo {
    private static volatile SingletonDemo singletonDemo= null;
    SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "    aaaaaaaaaaaaaaa");
    }

    /**
     * 双端检索机制DCL(可能会出现指令重排序情况，因此需要给对象添加volatile修饰)
     * @return
     */
    public static SingletonDemo getInstance(){
        if (singletonDemo == null){
            synchronized (SingletonDemo.class){
                if (singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance());
        for(int i = 1 ; i <= 10 ; i ++){
            new Thread(()-> {
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }

}
