package dp._0132_分割回文串2.动态规划;

public class Solution {
    public static int minCut(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (j - i == 1) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < len; i++) {
            if (isPalindrome[0][i]){
                dp[i] = 0;
                continue;
            }

            // 注意：这里是严格，要保证 s[j + 1:i] 至少得有一个字符串
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
