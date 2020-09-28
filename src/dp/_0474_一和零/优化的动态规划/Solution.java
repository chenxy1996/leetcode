package dp._0474_一和零.优化的动态规划;

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

        int[][] dp = new int[m + 1][n + 1];
        for(int k = 0; k < len; k++) {
            int zeroCnt = zero[k];
            int oneCnt = one[k];
            for(int i = m; i >= zeroCnt; i--) {
                for(int j = n; j >= oneCnt; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCnt][j - oneCnt] + 1);
                }
            }
        }

        return dp[m][n];
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
