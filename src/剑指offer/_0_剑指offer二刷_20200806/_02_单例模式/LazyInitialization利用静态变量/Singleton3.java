package 剑指offer._0_剑指offer二刷_20200806._02_单例模式.优化的利用静态变量;

public class Singleton3 {
    private static class InnerClass {
        private static final Singleton3 INSTANCE = new Singleton3();

        static {
            System.out.println("hello");
        }
    }

    private Singleton3() {}

    public static Singleton3 getInstance() {
        return InnerClass.INSTANCE;
    }
}
