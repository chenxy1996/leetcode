package 滑动窗口和字符串._03_无重复字符的最小子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用双指针
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (; r < chars.length; r++) {
            char c = chars[r];
            if (!map.containsKey(c)) {
                max = Math.max(max, r - l + 1);
            } else {
                int p = map.get(c);
                if (p < l) {
                    max = Math.max(max, r - l + 1);
                } else {
                    l = map.get(c) + 1;
                }

            }
            map.put(c, r);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
