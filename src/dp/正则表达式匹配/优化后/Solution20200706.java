package dp.正则表达式匹配.优化后;

public class Solution20200706 {
    public static boolean isMatch(String s, String p) {
        int m = p.length() + 1;
        int n = s.length() + 1;
        boolean[][] dp = new boolean[m][n];
        // 初始化第一行
        dp[0][0] = true;
        for (int i = 1; i < m; i++) {
            char pc = p.charAt(i - 1);
            for (int j = 0; j < n; j++) {
                if (pc == '?') {
                    dp[i][j] = j > 0 && dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || (j > 0 && dp[i][j - 1]);
                } else if (j > 0){
                    char sc = s.charAt(j - 1);
                    dp[i][j] =  (pc == sc) && (j > 0 && dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String s = "abcde";
        String p = "abc?";
        System.out.println(isMatch(s, p));
    }
}
