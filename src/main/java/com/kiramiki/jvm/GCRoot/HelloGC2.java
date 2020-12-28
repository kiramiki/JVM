package com.kiramiki.jvm.GCRoot;

/**
 * 常用基础参数
 *  -Xms   等价与 -XX: initialHeapSize
 *  -Xmx   等价于 -XX: MaxHeaPSize
 *  -Xss   等价鱼 -XX: ThreadStackSize
 *      [-Xss128k]
 *      windows默认为0，是根据虚拟内存来设置的大小
 *      其他环境默认1024k
 *  -Xmn   设置年轻代大小
 *  -XX:MetaspaceSize  元空间大小
 *      java8之后加入了元空间 概念和永久代相似都是对JVM规范中方法区的实现
 *      与永久代的区别在于:   ####元空间不在虚拟机中，而是在本地内存
 *          因此默认情况下元空间大小只受本地内存限制
 *   常用的配置
 * -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCSDetails -XX:+UseSerialGC
 */
public class HelloGC2 {
}
