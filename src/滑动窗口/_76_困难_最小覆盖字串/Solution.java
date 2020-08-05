package 滑动窗口._76_困难_最小覆盖字串;

public class Solution {
    public static String minWindow(String s, String t) {
        int[] stat = new int[128];
        for (char c : t.toCharArray()) {
            stat[c]++;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        int distance = 0;
        int minLen = Integer.MAX_VALUE;
        int lMin = 0;
        int[] seen = new int[128];

        // 移动右指针
        while (r < chars.length) {
            char c = chars[r];
            if (stat[c] != 0) {
                if (seen[c] < stat[c]) {
                    distance++;
                }
                seen[c]++;
                while (distance == t.length()) {
                    if (r - l + 1< minLen) {
                        lMin = l;
                        minLen = r - l + 1;
                    }
                    // 移动左边指针
                    char lc = chars[l];
                    if (stat[lc] != 0) {
                        if (seen[lc] == stat[lc]) {
                            distance--;
                        }
                        seen[lc]--;
                    }
                    l++;
                }
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(lMin, lMin + minLen);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(minWindow(S, T));
    }
}
