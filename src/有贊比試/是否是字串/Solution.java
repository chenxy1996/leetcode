package 有贊比試.是否是字串;

public class Solution {
    public boolean isSubsequence (String s, String t) {
        // write code here
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for(int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for(int j = 1; j <= n; j++) {
                char tc = t.charAt(j - 1);
                dp[i][j] = dp[i][j - 1];
                if (sc == tc) {
                    dp[i][j] |= dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Solution().isSubsequence(s, t));
    }
}
