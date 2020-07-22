package dp._5Difficult_MANACHER_最长回文字串;

/**
 * 这道题 dp 的填表顺序和之前见过的是不同的
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int maxLen = 1;
        String maxString = s.substring(0, 1);
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            char l = s.charAt(i);
            int[] temp = new int[len];
            temp[i] = 1;
            for (int j = i + 1; j <= len - 1; j++) {
                char r = s.charAt(j);
                // 区间 [i, j]
                if (j - i == 1) {
                    temp[j] = l == r ? 2 : 0;
                } else {
                    temp[j] = l == r ? (dp[j - 1] == 0 ? 0 : dp[j - 1] + 2) : 0;
                }
                if (temp[j] > maxLen) {
                    maxLen = temp[j];
                    maxString = s.substring(i, j + 1);
                }
            }
            dp = temp;
        }
        return maxString;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babeffeba"));
    }
}
