Java 的JMM (Java Memory Model):Java 内存模型
1.可见性
2.原子性
3.指令重排

关键字volatile的特性就是：
1.不保证原子性
2.具有可见性
3.禁止指令重排

保证可见性，可以使用关键字volatile ,synchronized ，或者JUC Lock接口的实现类
但是volatile只保证可见性，不保证原子性，还不是线程安全的
synchronized关键字和Lock接口实现类，都是可见性，原子性并存的
aaaaa 能提交上去么？