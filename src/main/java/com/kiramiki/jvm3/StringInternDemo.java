package com.kiramiki.jvm3;

/**
 * String.intern() 方法会先从字符串常量池中检索该字符串，如果已有会直接引用字符串常量吃中的对象，如果没有则创建然后加入字符串常量池中。
 *      为什么返回结果不一样？
 *          这是因为java在编译时，“java”这个变量在sun.misc.Version类中已经对"java"进行过引用，字符串常量池中已经包含了这个对象，因此会返回false。
 */
public class StringInternDemo {
    public static void main(String[] args) {
        //返回结果为true
        String s = new StringBuilder("mei").append("tuan").toString();
        System.out.println(s == s.intern());
        //返回结果为false
        String s1 = new StringBuilder("ja").append("va").toString();
        System.out.println(s1 == s1.intern());
    }
}
