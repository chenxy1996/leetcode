package LCP._19_题目很好_秋叶收藏集.动态规划;

public class Solution {
    public static int minimumOperations(String leaves) {
        int len = leaves.length();
        int[][] dp = new int[len + 1][3];
        char[] cs = leaves.toCharArray();
        for(int i = 1; i <= len; i++) {
            dp[i][0] = (cs[i - 1] == 'r') ? dp[i - 1][0] : dp[i - 1][0] + 1;
            if (i >= 2) {
                dp[i][1] = cs[i - 1] == 'r' ? Math.min(dp[i - 1][0], dp[i - 1][1]) + 1: Math.min(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][1] = len;
            }
            if (i >= 3) {
                dp[i][2] = cs[i - 1] == 'r' ? Math.min(dp[i - 1][1], dp[i - 1][2]) :
                        Math.min(dp[i - 1][1], dp[i - 1][2]) + 1;
            } else {
                dp[i][2] = len;
            }
        }
        return dp[len][2];
    }

    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        System.out.println(minimumOperations(leaves));
    }
}
