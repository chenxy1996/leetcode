package dp._32_困难_最长有效括号;

/**
 * 初见没有写出来,
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int len = s.length();
        char[] parentheses = s.toCharArray();
        int left = 0;
        int right = 0;
        // 从左往右
        for (int i = 0; i < len; i++) {
            char c = parentheses[i];
            if (c == '(') {
                left++;
            } else {
                if (left > right) {
                    right++;
                    if (left == right) {
                        max = Math.max(max, 2 * left);
                    }
                } else {
                    left = 0;
                    right = 0;
                }
            }
        }

        // 从右往左
        left = 0;
        right = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = parentheses[i];
            if (c == ')') {
                right++;
            } else {
                if (right > left) {
                    left++;
                    if (left == right) {
                        max = Math.max(max, left * 2);
                    }
                } else {
                    left = 0;
                    right = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()(()))((())((()))";
//        String s = "()(()";
//        String s = ")()())";
//        String s = "()(()";
        System.out.println(solution.longestValidParentheses(s));

    }
}
