package jianZhiOffer._47_礼物的最大价值;

public class Solution {
    /**
     * 更好的解法是直接在原来的 grid 二维数组中更改
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 初始化第一行
        dp[0][0] = grid[0][0];
        for (int k = 1; k < n; k++) {
            dp[0][k] = dp[0][k - 1] + grid[0][k];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
