package dp._87_困难_不会做_扰乱字符串;

/**
 * 这道题只想到用递归，用动态规划自己不会
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        // 统计各个字符串中各个字母的次数
        int[] map = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        for(int each : map) {
            if (each != 0) {
                return false;
            }
        }

        for(int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(new Solution().isScramble(s1, s2));
    }
}
