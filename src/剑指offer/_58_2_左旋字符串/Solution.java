package 剑指offer._58_2_左旋字符串;

public class Solution {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n + 1);
    }

    public static void main(String[] args) {
        String s = "abcdef";
        int offset = 2;
        System.out.println(reverseLeftWords(s, offset));
    }
}
