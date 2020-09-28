package dp._1278_困难_分割回文串3;

public class Solution {
    public static int palindromePartition(String s, int k) {
        int len;
        if (s == null || (len = s.length()) == 0 || k > len - 1) {
            return 0;
        }

        int[][] cost = new int[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if (j == i) {
                    cost[i][j] = 0;
                } else if (j - i == 1) {
                    cost[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                } else {
                    cost[i][j] = cost[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
                }
            }
        }

        int[][] dp = new int[len][k + 1];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = len;
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 1; j <= k && j <= i + 1; j++) {
                if (j == 1) {
                    dp[i][j] = cost[0][i];
                } else {
                    for(int d = 1; i - d >= 0; d++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - d][j - 1] + cost[i - d + 1][i]);
                    }
                }
            }
        }

        return dp[len - 1][k];
    }

    public static void main(String[] args) {
        String s = "aabd";
        System.out.println(palindromePartition(s, 2));
    }
}
