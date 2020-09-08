package 题目;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ExecotorsTest {
    public static void main(String[] args) {
//        method(null);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++) {
            int p = i;
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + p);
            });
        }
    }


    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
