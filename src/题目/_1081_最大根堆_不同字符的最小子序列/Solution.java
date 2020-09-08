package 题目._1081_最大根堆_不同字符的最小子序列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 这道题和 316 题一样，316 题目中用的是单调栈，这次用贪心 + 单调栈
 */
public class Solution {
    public String smallestSubsequence(String text) {
        String s = text;
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

    }
}
