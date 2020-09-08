import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock wl = lock.writeLock();
    ReentrantReadWriteLock.ReadLock rl = lock.readLock();

    public void read() {
        try {
            rl.lock();
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end read!");
        } catch (InterruptedException e) {
        } finally {
            rl.unlock();
        }
    }

    public void write() {
        try {
            wl.lock();
            rl.lock();
            System.out.println(Thread.currentThread().getName());
            System.out.println("end write!");
        } finally {
            wl.unlock();
            System.out.println("end read!");
            rl.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
        Thread t1 = new Thread(() -> {
            test.read();
        });
        t1.setName("t1");


        Thread t3 = new Thread(() -> {
            test.write();
        });
        t3.setName("t3");
        t3.start();

        t1.start();
        Thread t2 = new Thread(() -> {
            test.write();
        });
        t2.setName("t2");
        t2.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
