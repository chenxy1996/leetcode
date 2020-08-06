package 滑动窗口._424_有点难以理解_替换后的最长重复字符;

import java.util.HashMap;
import java.util.Map;

public class MySolution {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxHistoryCount = 0;
        int l = 0;
        int i = 0;
        for (; i < chars.length; i++) {
            char c = chars[i];
            int count = map.getOrDefault(c, 0);
            map.put(c, ++count);
            maxHistoryCount = Math.max(maxHistoryCount, count);
            if (maxHistoryCount + k < i - l + 1) {
                char lp = chars[l];
                map.put(lp, map.get(lp) - 1);
                l++;
            }
        }
        return i - l;
    }

    public static void main(String[] args) {
        String s = "AABACBBA";
        System.out.println(characterReplacement(s, 2));
    }
}
