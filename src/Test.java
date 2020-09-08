import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class Test {
    private static volatile boolean block = true;
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            while (block) {
            }
            block = true;
            System.out.println("ok1");
        });
        a.start();

        Thread b = new Thread(() -> {
            while (!block) {
            }
            block = false;
            System.out.println("ok2");
        });
        b.start();

        a.join();
        b.join();

        System.out.println("end");
    }
}
