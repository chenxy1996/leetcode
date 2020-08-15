package 剑指offer._0_剑指offer二刷_20200806._02_单例模式.LazyInitialization利用静态变量;

public final class Singleton3 {
    private static class InnerClass {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    private Singleton3() {}

    public static Singleton3 getInstance() {
        return InnerClass.INSTANCE;
    }
}
