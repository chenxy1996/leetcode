package 阿里.从两端拿宝物;


public class Solution {
    private static int get(int[][] values, int k) {
        int n = values.length;
        int[][] v = new int[n][2];
        for(int i = 0; i < n; i++) {
            int m = values[i].length;
            v[i] = new int[2];
            v[i][0] = Math.max(values[i][0], values[i][m - 1]);
            int a = values[i][0] + values[i][m - 1];
            int b = values[i][m - 1] + values[i][m - 2];
            int c = values[i][0] + values[i][1];
            v[i][1] = Math.max(a, Math.max(b, c));
        }

        int[][] dp = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(v[i - 1][0] + dp[i - 1][j - 1], dp[i - 1][j]);
                if (j >= 2) {
                    dp[i][j] = Math.max(dp[i][j], v[i - 1][1] + dp[i - 1][j - 2]);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int[][] values = {
                {1, 100, 2, 7},
                {2, 50, 3, 8},
                {3, 10}
        };
        System.out.println(get(values, 3));
    }
}
