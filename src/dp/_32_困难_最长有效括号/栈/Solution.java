package dp._32_困难_最长有效括号.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(-1);
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.addLast(i);
            } else {
                /**
                 * 下面这几行着重理解
                 */
                deque.removeLast();
                if (deque.isEmpty()) {
                    deque.addLast(i);
                } else {
                    max = Math.max(i - deque.peekLast(), max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("())"));
    }
}
