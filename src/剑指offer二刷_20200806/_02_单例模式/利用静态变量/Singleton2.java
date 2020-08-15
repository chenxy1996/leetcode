package 剑指offer._0_剑指offer二刷_20200806._02_单例模式.利用静态变量;

import 剑指offer._0_剑指offer二刷_20200806._02_单例模式.普通多线程单例创建.Singleton1;

public final class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
