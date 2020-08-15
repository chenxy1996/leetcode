package 剑指offer._0_剑指offer二刷_20200806._19_01_正则表达式匹配.动态规划;

public class Solution {
    /**
     * 可以用滚动数组把空间复杂度降为 O(N)
     */
    public static boolean isMatch(String s, String p) {
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
                    dp[i][j] = dp[i - 2][0];
                } else if (j > 0) {
                    char sc = s.charAt(j - 1);
                    if (pc == '*') {
                        dp[i][j] |= dp[i - 2][j]; // 匹配 0 个
                        dp[i][j] |= dp[i - 1][j]; // 匹配 1 个
                        char prevPc = p.charAt(i - 2);
                        dp[i][j] |= (prevPc == '.' || prevPc == sc) && dp[i][j - 1];
                    } else if (pc == '.' || sc == pc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "";
        String p = ".*a*b*c";
        System.out.println(isMatch(s, p));
    }
}
