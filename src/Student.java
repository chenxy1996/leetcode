import java.lang.management.RuntimeMXBean;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public abstract class Student {
    private String name;
    public abstract boolean isSomething(String name);

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5);
        Runnable r = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 到达屏障 A!" );
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " 突破屏障 A!" );
                System.out.println(Thread.currentThread().getName() + " 到达屏障 B!" );
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " 突破屏障 B!" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        for(int i = 0; i < 5; i++) {
            Thread t = new Thread(r, String.valueOf(i));
            t.start();
        }
    }
}
