package com.wunderbar.jmm;

/**
 * @author Rommel
 * @date 2020/7/26 9:31
 * @description JMM 内存可见性带来的问题演示
 * 多线程的创建，可以用new Thread()
 * 也可以用Executors.newFixedThreadPool(int nThreads);
 */
public class VisibilityProblem {
    int a = 10;
    int b = 20;

    //修改变量
    private void change() {
        a = 30;
        b = a;
    }

    //读取变量
    private void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        //条件永远为true，循环下去，发现每次改完变量值之后，每次读取的值都不一样
        while (true) {
            final VisibilityProblem problem = new VisibilityProblem();

            //t1线程负责更改数据
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //改变变量
                    problem.change();
                }
            });
            t1.start();

            //t2线程负责读取数据
            Thread t2 = new Thread(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //读取变量
                    problem.print();
                }
            });
            t2.start();
        }
    }


}
