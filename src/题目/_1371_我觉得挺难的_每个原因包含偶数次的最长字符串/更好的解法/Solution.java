package 题目._1371_我觉得挺难的_每个原因包含偶数次的最长字符串.更好的解法;

public class Solution {
    public int findTheLongestSubstring(String s) {
        int[] map = new int[32];
        for(int i = 0; i < 32; i++) {
            map[i] = Integer.MAX_VALUE;
        }
        map[0] = -1;
        char[] cs = s.toCharArray();
        int key = 0;
        int ans = 0;
        for(int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == 'a') {
                key ^= 1;
            } else if (c == 'e') {
                key ^= 2;
            } else if (c == 'i') {
                key ^= 4;
            } else if (c == 'o') {
                key ^= 8;
            } else if (c == 'u') {
                key ^= 16;
            }
            if (map[key] == Integer.MAX_VALUE) {
                map[key] = i;
            } else {
                ans = Math.max(ans, i - map[key]);
            }
        }
        return ans;
    }
}
