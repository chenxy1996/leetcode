package dp.正则匹配_难点的;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//'.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            char pc = p.charAt(i - 1);
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    if (pc == '*') {
                        dp[i][0] =  dp[i - 2][0];
                    }
                } else {
                    char sc = s.charAt(j - 1);
                    if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];
                        char prevPc = p.charAt(i - 2);
                        if (sc == prevPc || prevPc == '.') {
                            dp[i][j] |= dp[i - 1][j] || // 匹配一个但前字符
                                    dp[i][j - 1]; // 匹配多个
                        }
                    } else {
                        dp[i][j] = sc == pc && dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab";
        String p = ".*";
        System.out.println(solution.isMatch(s, p));
    }
}
