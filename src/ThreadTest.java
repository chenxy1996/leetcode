import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static volatile int state = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void printAA() throws InterruptedException {
        lock.lock();
        try {
            while (state != 0) {
                condition.await();
            }
            System.out.println("AA");
            state = 1;
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public static void printBB() throws InterruptedException {
        lock.lock();
        try {
            while (state != 1) {
                condition.await();
            }
            System.out.println("BB");
            state = 2;
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public static void printCC() throws InterruptedException {
        lock.lock();
        try {
            while (state != 2) {
                condition.await();
            }
            System.out.println("CC");
            state = 0;
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public static void method(int k) throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                for (int i = 0; i < k; i++) {
                    printAA();
                }
            } catch (InterruptedException e) {
            }
        });

        Thread b = new Thread(() -> {
            try {
                for (int i = 0; i < k; i++) {
                    printBB();
                }
            } catch (InterruptedException e) {
            }
        });

        Thread c = new Thread(() -> {
            try {
                for (int i = 0; i < k; i++) {
                    printCC();
                }
            } catch (InterruptedException e) {
            }
        });

        a.start();
        b.start();
        c.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        method(5);
    }
}
