package 剑指offer._0_剑指offer二刷_20200806._14_01_减绳子_动态规划;

public class Solution {
    public static int cuttingRopes(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int x = 2;
            while (i - x >= 2 && x <= i >> 1) {
                dp[i] = Math.max(dp[i], dp[x] * dp[i - x]);
                x++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRopes(9));
    }
}
