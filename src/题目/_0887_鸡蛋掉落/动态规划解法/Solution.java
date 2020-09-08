package 题目._0887_鸡蛋掉落.动态规划解法;

/**
 * 超出时间了
 */
public class Solution {
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        // 只有一个鸡蛋的情况
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    min = Math.min(min, Math.max(
                            dp[i - 1][k - 1], // 鸡蛋碎了
                            dp[i][j - k] // 鸡蛋没碎
                    ));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(2, 200));
    }
}
