package dp._0647_回文字串;

public class Solution {
    public static int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int ans = 0;

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
