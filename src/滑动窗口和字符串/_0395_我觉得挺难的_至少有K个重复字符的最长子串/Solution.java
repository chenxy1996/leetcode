package 滑动窗口和字符串._0395_我觉得挺难的_至少有K个重复字符的最长子串;

public class Solution {
    private int ans = 0;

    public int longestSubstring(String s, int k) {
        search(s.toCharArray(), 0, s.length(), k);
        return ans;
    }

    private void search(char[] cs, int l, int r, int k) {
        if (l >= r) {
            return;
        }

        int[] map = new int[26];

        for(int i = l; i < r; i++) {
            map[cs[i] - 'a']++;
        }

        int i = l;
        for(; i < r; i++) {
            if (map[cs[i] - 'a'] < k) {
                break;
            }
        }

        if (i == r) {
            ans = Math.max(i - l, ans);
        }
        if (i < r) {
            search(cs, l, i, k);
            search(cs, i + 1, r, k);
        }
    }

    public static void main(String[] args) {
        String s = "ababacb";
        int k = 3;
        System.out.println(new Solution().longestSubstring(s, k));
    }
}
