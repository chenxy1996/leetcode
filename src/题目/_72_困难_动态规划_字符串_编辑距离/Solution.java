package 题目._72_困难_动态规划_字符串_编辑距离;

public class Solution {
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int m = word1.length();
        int n = word2.length();
        if (m < n) {
            return minDistance(word2, word1);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int[] tmp = new int[n + 1];
            tmp[0] = i;
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    tmp[j] = dp[j - 1];
                } else {
                    tmp[j] = Math.min(
                            dp[j - 1], // 改 c1
                            Math.min(
                                    dp[j], // 删 c1
                                    tmp[j - 1] // 添加 c1
                            )
                    ) + 1;
                }
            }
            dp = tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "ate";
        System.out.println(minDistance(word1, word2));
    }
}
