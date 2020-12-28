package com.kiramiki.jvm.GCRoot;

/**
 * 在java中，那些可以做GC Roots的对象
 *      虚拟机栈（栈帧中的本地变量表）中引用的对象
 *      方法区中的类静态属性引用的对象
 *      方法区中的常量引用的对象
 *      本地方法栈中JNI（也就是native方法中引用的对象）
 */
public class GCRootDemo {
}
