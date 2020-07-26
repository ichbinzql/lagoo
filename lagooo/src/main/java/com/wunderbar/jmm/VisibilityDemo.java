package com.wunderbar.jmm;

/**
 * @author Rommel
 * @date 2020/7/26 9:22
 * @description JMM 可见性
 */
public class VisibilityDemo {
    /**
     * Java主内存中有个变量a,初始化值为10;
     * 几个线程把主内存的变量刷到工作内存，并准备启动线程，执行方法
     * 由于CPU上下文切换，线程1 ，线程2 ，执行write() ,read()方法的顺序不保证
     * 如果线程1先执行了write方法，把变量a的值改为20 ，还没刷回主内存
     * 线程2也把a=10刷到工作内存，应该刷a=20，这就存在了数据不一致，线程安全问题
     * 就是线程1的重新赋值操作对线程2不是内存可见性的。
     *
     * */

    int a=10;

    public void write(){
        int a =20;
    }

    public void read(){
        int b =a ;
    }

}
