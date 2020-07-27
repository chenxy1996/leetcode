package 单调栈._316_困难_去除重复字母;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int[] dict = new int[26];
        boolean[] exist = new boolean[26];
        for (char c : chars) {
            dict[c - 'a'] += 1;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (!exist[c - 'a']) {
                char top;
                while (!stack.isEmpty() && (top = stack.peekLast()) > c && dict[top - 'a'] > 0) {
                    stack.removeLast();
                    exist[top - 'a'] = false;
                }
                stack.addLast(c);
                exist[c - 'a'] = true;
            }
            dict[c - 'a'] -= 1;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.removeFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbacdcbc";
        System.out.println(solution.removeDuplicateLetters(s));
    }
}
