public class TheadLocalTest {
    static ThreadLocal<Integer> s = new ThreadLocal<>();
    public static void main(String[] args) {
        s.set(1);
        new Thread(() -> {
            s.set(2);
            for(int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "\t : " + s.get());
            }
        }, "Thread1111").start();
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "\t : " + s.get());
        }
    }
}
