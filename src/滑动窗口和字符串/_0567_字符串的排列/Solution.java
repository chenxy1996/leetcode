package 滑动窗口和字符串._567_字符串的排列;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        short[] content = new short[26];
        for(char c : s1.toCharArray()) {
            content[c - 'a']++;
        }

        char[] chars = s2.toCharArray();
        int l = 0, r = 0;
        short[] seen = new short[26];
        while (r < chars.length) {
            char c = chars[r];
            seen[c - 'a']++;
            r++;
            while (seen[c - 'a'] > content[c - 'a']) {
                seen[chars[l] - 'a']--;
                l++;
            }
            if (r - l == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
