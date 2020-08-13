package 字符串._394_中等_字符串解码.利用栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        Deque<Integer> integers = new ArrayDeque<>();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (isDigit(c)) {
                int l = i;
                while (isDigit(cs[++i])) {
                }
                integers.addLast(Integer.parseInt(s.substring(l, i)));
                i--;
            } else if (c == '[') {
                characters.add(c);
            } else if (c == ']') {
                int count = integers.removeLast();
                int p = characters.size() - 1;
                while (characters.get(p) != '[') {
                    p--;
                }
                if (p == 0) { // 说明字符栈中没有别的 '['
                    while (count > 0) {
                        for (int j = p + 1; j < characters.size(); j++) {
                            sb.append(characters.get(j));
                        }
                        count--;
                    }
                    characters.clear();
                } else {
                    int limit = characters.size();
                    while (count > 1) {
                        for (int j = p + 1; j < limit; j++) {
                            characters.add(characters.get(j));
                        }
                        count--;
                    }
                    characters.remove(p);
                }
            } else { // 为其它字符
                if (integers.isEmpty()) {
                    sb.append(c);
                } else {
                    characters.add(c);
                }
            }
        }
        return sb.toString();
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a2[c]]";
        System.out.println(solution.decodeString(s));
    }
}
