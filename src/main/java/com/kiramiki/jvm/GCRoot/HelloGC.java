package com.kiramiki.jvm.GCRoot;

import java.util.concurrent.TimeUnit;

/**
 * 常用的java 参数主要有三种
 *  java -version
 *  -X
 *  -XX （重点且常用）
 * 如何查看 进程携带的java 参数信息？
 *  jps -l 找到需要查看的进程信息
 *  jinfo -flag [需要查看的参数名称] [进程编号]
 *          例如 jinfo -flag PrintGCDetails 7908
 *
 *          D:\kiramiki\JVM>jinfo -flag PrintGCDetails 7908
 *          -XX:-PrintGCDetails
 *      boolean 类型 -代表关闭，
 *                  +代表开启
 *      KV类型 设置值
 *      例如
 *      jinfo -flag MetaspaceSize 7908
 *          D:\kiramiki\JVM>jinfo -flag MetaspaceSize 12208
 *          -XX:MetaspaceSize=134217728
 *          可以通过这种方式查看系统默认值
 *          MetaspaceSize 运行空间大小
 *          MaxTenuringThreshold 对象多久进入老年区
 *          D:\kiramiki\JVM>jinfo -flag MetaspaceSize 7260
 *          -XX:MetaspaceSize=21807104
 *     jinfo -flags 7908 查看所有参数信息
 *              D:\kiramiki\JVM>jinfo -flags 7260
                * VM Flags:
                * -XX:CICompilerCount=12 -XX:ConcGCThreads=5 -XX:G1ConcRefinementThreads=18 -XX:G1HeapRegionSize=2097152 -XX:GCDrainStackTargetSize=64 -XX:InitialHeapSize=268435456 -XX:MarkStackSize=4194304 -XX:MaxHeapSize=4282384384 -XX:MaxNewSize=2569011200 -XX:Mi
                * nHeapDeltaBytes=2097152 -XX:MinHeapSize=8388608 -XX:NonNMethodCodeHeapSize=7602480 -XX:NonProfiledCodeHeapSize=122027880 -XX:ProfiledCodeHeapSize=122027880 -XX:ReservedCodeCacheSize=251658240 -XX:+SegmentedCodeCache -XX:SoftMaxHeapSize=4282384384 -
                * XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseG1GC -XX:-UseLargePagesIndividualAllocation
 *     如何解释-Xms 和-Xmx 参数 属于-XX参数吗？
 *          -Xms == -XX:InitialHeapSize=268435456
 *          -Xms == -XX:MaxHeapSize=4282384384
 *
 *   查看初始设置的全部参数 java -XX:+PrintFlagsInitial
 *      := 表示人为修改过或JVM根据自身机器调整过的参数
 *   查看人为修改或JVM修改过的参数 java -XX:+PrintFlagsFinal -version
 *   查看 java -XX:+PrintCommandLineFlags -version
 *      -XX:ConcGCThreads=5 -XX:G1ConcRefinementThreads=18 -XX:GCDrainStackTargetSize=64 -XX:InitialHeapSize=267586880 -XX:MarkStackSize=4194304 -XX:MaxHeapSize=4281390080 -XX:MinHeapSize=6815736 -XX:+PrintCommandLineFlags -XX:ReservedCodeCacheSize=2516582
 *      40 -XX:+SegmentedCodeCache -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseG1GC -XX:-UseLargePagesIndividualAllocation
 *    -XX:PrintGCDetails 查看GC详细情况
 *    -XX:SurvivorRatio=8 设置Eden 区比例
 *    -XX:NewRatio 设置新生代和老年代占比 默认是2。 也就是新生代站三分之一，老年代占三分之二
 *
 */
public class HelloGC {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Byte[] bytes =new Byte[50*1024*1024];
    }
}
