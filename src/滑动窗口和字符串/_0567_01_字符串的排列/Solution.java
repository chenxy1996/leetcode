package 滑动窗口和字符串._0567_01_字符串的排列;

public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(char c : s1.toCharArray()) {
            map[c - 'a']++;
        }
        int l = 0, r = 0;
        int[] counter = new int[26];
        while (r < s2.length()) {
            char c = s2.charAt(r);
            r++;
            counter[c - 'a']++;
            while (counter[c - 'a'] > map[c - 'a']) {
                counter[s2.charAt(l) - 'a']--;
                l++;
            }
            if (r - l == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
