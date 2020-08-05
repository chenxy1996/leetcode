package dp._32_困难_最长有效括号.动态规划;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] parentheses = s.toCharArray();
        int len = parentheses.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                char c = parentheses[i];
                if (c == ')') {
                    char pc = parentheses[i - 1];
                    if (pc == '(') {
                        dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    } else {
                        int p = i - dp[i - 1] - 1;
                        if (p >= 0 && parentheses[p] == '(') {
                            dp[i] = 2 + dp[i - 1] + (p - 1 >= 0 ? dp[p - 1] : 0);
                        }
                    }
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()())";
        System.out.println(solution.longestValidParentheses(s));
    }
}
