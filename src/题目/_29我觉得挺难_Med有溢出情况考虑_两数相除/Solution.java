package 题目._29我觉得挺难_Med有溢出情况考虑_两数相除;

public class Solution {
    /**
     * 超出时间了
     */
    public static int divide(int dividend, int divisor) {
        // 如果 divisor 为 Integer.MIN_VALUE
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean flag = (dividend >>> 31) == (divisor >>> 31); // true：符号相同，false：符号不相同
        int supplement = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MIN_VALUE + 1; // 防止下面取绝对值溢出
            supplement = 1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while (dividend - divisor >= 0) {
            res++;
            dividend -= divisor;
        }
        if (supplement + dividend != divisor) {
            supplement = 0;
        }
        if (flag) {
            // 符号相同返回结果应该为正数
            return res == Integer.MAX_VALUE ? res : res + supplement;
        } else {
            // 返回结果为负数
            return -res - supplement;
        }
    }


    public static void main(String[] args) {
        int dividend = Integer.MAX_VALUE;
        int divisor = 2;
        System.out.println(divide(dividend, divisor));
        System.out.println(dividend / divisor);
    }
}
