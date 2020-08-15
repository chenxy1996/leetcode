package 剑指offer._0_剑指offer二刷_20200806._17_01_打印从1到最大的n位数;

public class Solution {
    public static void print1ToMaxOfNDigits(int n) {
        char[] chars = new char[n];
        print(chars, 0);
    }

    private static void print(char[] chars, int p) {
        if (p == chars.length) {
            int i = 0;
            while (i < p && chars[i] == '0') {
                i++;
            }
            if (i < p) {
                System.out.println(String.valueOf(chars, i, chars.length - i));
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[p] = (char) ('0' + i);
            print(chars, p + 1);
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(100);
    }
}
