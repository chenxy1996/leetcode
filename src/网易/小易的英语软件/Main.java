package 网易.小易的英语软件;

import java.util.Scanner;

public class Main {
    private static int[] prefix = new int[151];
    private static int[] scores;

    private static void query(int n) {
        double res = (prefix[scores[n - 1]] - 1) / ((double) scores.length);
        System.out.println(String.format("%.6f", res * 100));
    }

    public static void main(String[] args) {
        int[] map = new int[151];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scores = new int[n];
        for(int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            scores[i] = score;
            map[score]++;
        }

        int sum = 0;
        for(int i = 0; i <= 150; i++) {
            sum += map[i];
            prefix[i] = sum;
        }

        int q = scanner.nextInt();
        for(int i = 0; i < q; i++) {
            query(scanner.nextInt());
        }
    }
}
