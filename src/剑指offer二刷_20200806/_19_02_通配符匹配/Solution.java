package 剑指offer._0_剑指offer二刷_20200806._19_02_通配符匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }

        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 1; i <= m; i++) {
            char pc = p.charAt(i - 1);
            for(int j = 0; j <= n; j++) {
                if (j == 0 && pc == '*') {
                    dp[i][j] = dp[i - 1][0];
                } else if (j > 0) {
                    char sc = s.charAt(j - 1);
                    if (pc == '?' || sc == pc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
