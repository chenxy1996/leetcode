package 单调栈._556_03_下一个更大的元素;


import java.util.Arrays;

public class Solution {
    public static int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        for (int i = len - 2; i >=  0; i--) {
            char c = chars[i];
            int pos = findPos(chars, i + 1, len - 1, c);
            if (pos == len) {
                move(chars, i, len - 1);
            } else {
                char temp = chars[i];
                chars[i] = chars[pos];
                chars[pos] = temp;
                break;
            }
        }
        String s = String.valueOf(chars);
        long res = Long.valueOf(s);
        if (res <= n || res > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) res;
        }
    }

    // 排序数组中某个区间内大于某个数的第一个位置
    private static int findPos(char[] chars, int i, int j, char target) {
        int s = i;
        int e = j;
        while (s <= e) {
            int m = s + (e - s) / 2;
            char val = chars[m];
            if (val <= target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    private static void move(char[] chars, int i, int j) {
        char temp = chars[i];
        for (int k = i; k < j; k++) {
            chars[k] = chars[k + 1];
        }
        chars[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1999999999;
//        char[] chars = {'2', '5', '5'};
//        System.out.println(findPos(chars, 0, 1, '3'));
        System.out.println(nextGreaterElement(n));
    }

}
