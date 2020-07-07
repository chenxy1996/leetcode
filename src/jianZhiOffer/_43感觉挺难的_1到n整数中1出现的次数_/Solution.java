package jianZhiOffer._43感觉挺难的_1到n整数中1出现的次数_;

import jdk.swing.interop.SwingInterOpUtils;

public class Solution {
    // 递归
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n >= 1 && n <= 9) {
            return 1;
        }
        // 此时 n 至少有两位数
        // 获得最高位
        int leftmost = getHighestBitNumber(n);
        int pow = (int) Math.pow(10,getBitsNumber(n) - 1);
        int last = n - pow * leftmost;
        if (leftmost > 1) {
            // 最左边的数字不为1, 那么是大于1的
            return pow + // 1开头数字的总数
                    leftmost * countDigitOne(pow - 1) +
                        countDigitOne(last);
        } else {
            // 最左边的数字为1
            return last + 1 + // 1开头数字的总数
                    countDigitOne(last) +
                        countDigitOne(pow - 1);
        }
    }

    private static int getHighestBitNumber(int x) {
        while (x >= 10) {
            x = x / 10;
        }
        return x;
    }

    private static int getBitsNumber(int x) {
        int count = 0;
        while (x > 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 11;
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(21));
    }
}
