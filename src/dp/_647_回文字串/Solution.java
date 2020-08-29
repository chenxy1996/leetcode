package dp._647_回文字串;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Solution {
    public static int countSubstrings(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
            ans++;
        }
        for(int i = len - 2; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                boolean res;
                res = s.charAt(i) == s.charAt(j) &&
                        (j - i == 1 ? true : dp[i + 1][j - 1]);
                if (res) {
                    ans++;
                }
                dp[i][j] = res;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
