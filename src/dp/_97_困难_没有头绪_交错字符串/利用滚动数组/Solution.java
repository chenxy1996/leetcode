package dp._97_困难_没有头绪_交错字符串.利用滚动数组;

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
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // 第一行初始化
        for(int i = 1; i <= n; i++) {
            if (sc3[i - 1] == sc2[i - 1]) {
                dp[i] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                char c3 = sc3[i + j - 1];
                if (j > 0) {
                    dp[j] = (c3 == sc1[i - 1] && dp[j]) ||
                            (c3 == sc2[j - 1] && dp[j - 1]);
                } else {
                    dp[0] = sc1[i - 1] == c3 && dp[j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
