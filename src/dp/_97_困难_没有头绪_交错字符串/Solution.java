package dp._97_困难_没有头绪_交错字符串;

public class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        int q = s3.length();
        if (m + n != q) {
            return false;
        }
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        char[] sc3 = s3.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 第一行
        for(int i = 1; i <= n; i++) {
            if(sc2[i - 1] == sc3[i - 1]) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        // 第一列
        for(int i = 1; i <= m; i++) {
            if (sc1[i - 1] == sc3[i - 1]) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char c3 = sc3[i + j - 1];
                dp[i][j] = (sc1[i - 1] == c3 && dp[i - 1][j]) ||
                            (sc2[j - 1] == c3 && dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcbc";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
