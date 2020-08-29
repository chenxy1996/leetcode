package dp._115_困难_不同的字符串子序列;

public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int n = s.length();
        int m = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i <= m; i++) {
            char tc = t.charAt(i - 1);
            int[] temp = new int[n + 1];
            for(int j = 1; j <= n; j++) {
                char sc = s.charAt(j - 1);
                temp[j] = temp[j - 1] + (sc == tc ? dp[j - 1] : 0);
            }
            dp = temp;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(new Solution().numDistinct(s, t));
    }
}
