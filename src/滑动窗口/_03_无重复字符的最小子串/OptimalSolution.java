package 滑动窗口._03_无重复字符的最小子串;

import java.util.HashMap;
import java.util.Map;

public class OptimalSolution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (; r < chars.length; r++) {
            char c = chars[r];
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
            }
            map.put(c, r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
