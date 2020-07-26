package com.wunderbar.jmm;

/**
 * @author Rommel
 * @date 2020/7/26 9:15
 * @description JMM内存可见性 示例
 */
public class VisibleDemo {

    static int a = 10;


    public static void write() {
        a = 20;
        System.out.println("a=" + a);
    }

    public static void read() {
        int b = a;
        System.out.println("b=" + b);

    }

    /**
     *多线程活动中，方法的调用顺序
     * 获取的方法返回值，不同
     * */
    public static void main(String[] args) {

        read();
        write();
    }
}
