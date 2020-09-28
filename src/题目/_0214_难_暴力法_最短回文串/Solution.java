package 题目._0214_难_暴力法_最短回文串;

public class Solution {
    public static String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        int len = s.length();
        int i = 0;
        for(; i <= len; i++) {
            if (s.substring(0, len - i).equals(rs.substring(i))) {
                break;
            }
        }
        return rs.substring(0, i) + s;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }
}
