package 题目.字符串映射;

public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] map = new char[256];
        boolean[] exist = new boolean[256];
        for(int i = 0; i < 26; i++) {
            map[i] = 0;
        }
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map[sc] == 0) {
                if (exist[tc]) {
                    return false;
                } else {
                    map[sc] = tc;
                    exist[tc] = true;
                }

            } else {
                if (map[sc] != tc) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "13";
        String t = "42";
        System.out.println(isIsomorphic(s, t));
    }
}
