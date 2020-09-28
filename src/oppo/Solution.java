package oppo;

import java.net.Socket;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    private volatile int flag = 0;

    private synchronized void printA() throws InterruptedException {
        while (flag != 0) {
            wait();
        }
        System.out.print("A");
        flag++;
        notifyAll();
    }

    private synchronized void printB() throws InterruptedException {
        while (flag != 1) {
            wait();
        }
        System.out.print("B");
        flag++;
        notifyAll();
    }

    private synchronized void printC() throws InterruptedException {
        while (flag != 2) {
            wait();
        }
        System.out.print("C");
        flag = 0;
        notifyAll();
    }

    public static void printABC() throws InterruptedException {
        Solution solution = new Solution();
        Runnable r1 = () -> {
            while (true) {
                try {
                    solution.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = () -> {
            while (true) {
                try {
                    solution.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r3 = () -> {
            while (true) {
                try {
                    solution.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int left = 1;
        int right = m * n;
        k = m * n - k + 1;
        while (left < right) {
            // 注意int类型溢出问题！
            int mid = (int)(((long)left + right) / 2);
            // 求小于等于 mid 的数量
            int row = mid / m;
            int count = row * m;
            for (int i = row + 1; i <= n; i++) {
                count += mid / i;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    private static void print(int[] nums) {
        for(int each : nums) {
            int cnt = 0;
            while (each != 0) {
                cnt++;
                each /= 2;
            }
            System.out.println(cnt);
        }
    }

    private static void printSym(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if (j == i) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && j != i) {
                    System.out.println(s.substring(i, j + 1));
                }
            }
        }
    }
}
