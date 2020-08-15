package 剑指offer._0_剑指offer二刷_20200806._02_单例模式.普通多线程单例创建;

public final class Singleton1 {
    private static volatile Singleton1 instance;
    private Singleton1() {};

    public static Singleton1 getInstance() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
