package 百度校招.最大正方形;

import java.util.Scanner;

public class Main {
    public static long maxArea(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long[][] dp = new long[m + 1][n + 1];
        long ans = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 'M') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[][] matrix = new char[m][n];
        for(int i = 0; i < m; i++) {
            String row = scanner.next();
            for(int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }
        System.out.println(maxArea(matrix));
    }
}
