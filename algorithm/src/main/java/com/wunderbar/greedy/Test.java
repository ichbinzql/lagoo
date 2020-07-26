package com.wunderbar.greedy;

import java.util.HashSet;

/**
 * @author Rommel
 * @date 2020/3/28 12:41
 * @description HashSet.retainAll()方法返回两个集合的并集，返回给前面集合
 */
public class Test {

    public static void main(String[] args) {
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("1");
        hashSet1.add("2");
        hashSet1.add("3");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("1");
        hashSet2.add("2");
        hashSet2.add("100");

        hashSet1.retainAll(hashSet2);
        System.out.println("hashSet1 = " + hashSet1);

        System.out.println();

        String str = "Hello hello world world ";
        String newStr = str.replaceAll("world", "atguigu");
        System.out.println("newStr = " + newStr);
    }
}
