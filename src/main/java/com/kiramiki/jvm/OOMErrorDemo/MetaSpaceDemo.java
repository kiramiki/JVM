package com.kiramiki.jvm.OOMErrorDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * Java 8之后使用的是元空间Metaspace来代替永久代的作用
 *
 *  他跟永久代最大的区别就在于他使用的是本地内存，而永久代在虚拟机中
 *  即在java8中， class metadata(the virtual machines internal presentation of java class ) ，被储存在叫做Metaspace native memory中
 *
 *  都是在方法区中hotspot中的实现
 *
 *  JDK1.6及以前，常量池在方法区，这时du的方法区也zhi叫做永久代dao；
 *  JDK1.7的时候，方法区zhuan合并到了堆内存中，这时shu的常量池也可以说是在堆内存中；
 *  JDK1.8及以后，方法区又从堆内存中剥离出来了，但实现方式与之前的永久代不同，这时的方法区被叫做元空间，常量池就存储在元空间
 *
 *  永久代(元空间)存放以下信息：
 *      虚拟机加载的类信息
 *      运行时常量池
 *      静态变量
 *      即时编译后的代码
 *
 *
 *  通过cdlib的反射机制，不断创建类，即可产生这个异常
 *      因为本地java版本过高 会先提示
 *      Error occurred during initialization of VM
 *       MaxMetaspaceSize is too small.
 */
public class MetaSpaceDemo {
    static class Oom{}

    public static void main(String[] args) {
        int i = 0 ;
        try {
            while(true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(Oom.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println("*************发生了多少次异常" + i);
            e.printStackTrace();
        }
    }
}
