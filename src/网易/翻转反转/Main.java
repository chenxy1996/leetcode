package 网易.翻转反转;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n > 1 && m > 1) {
                System.out.println(0);
            } else if (m == 1 && n == 1) {
                System.out.println(1);
            } else if (m == 1) {
                System.out.println(n - 2);
            } else {
                System.out.println(m - 2);
            }
        }
    }
}
