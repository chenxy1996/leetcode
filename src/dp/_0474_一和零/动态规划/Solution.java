package dp._0474_一和零.动态规划;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zero = new int[len];
        int[] one = new int[len];

        for(int i = 0; i < len; i++) {
            String s = strs[i];
            zero[i] = countZero(s);
            one[i] = s.length() - zero[i];
        }

        int[][][] dp = new int[m + 1][n + 1][len + 1];
        for(int k = 1; k <= len; k++) {
            int zeroCnt = zero[k - 1];
            int oneCnt = one[k - 1];
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j ++) {
                    // 不选当前的字符串
                    dp[i][j][k] = dp[i][j][k - 1];
                    // 选择当前的字符串
                    if (zeroCnt <= i && oneCnt <= j) {
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - zeroCnt][j - oneCnt][k - 1]);
                    }
                }
            }
        }
        return dp[m][n][len];
    }

    private int countZero(String s) {
        int ans = 0;
        for(char c : s.toCharArray()) {
            if (c == '0') {
                ans++;
            }
        }
        return ans;
    }
}
