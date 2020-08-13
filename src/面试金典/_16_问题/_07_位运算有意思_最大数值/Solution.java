package 面试金典._16_问题._07_位运算有意思_最大数值;

/**
 * 首先 a - b 得到差值x
 *
 * 由于是long型，右移63位得到符号位，注意负号不变，那么正数右移63位就是0，负数右移63位就是-1
 *
 * 那么得出我们的计算公式 (1 + k) * a - b * k
 * 当 x >= 0 的时候，k = 0, 即 a > b
 * 那么我们的计算公式为 1 * a - b * 0 = a
 *
 * 当 x < 0的时候，k = -1, 即 b > a
 * 那么我们的计算公式为 0 * a - b * ( -1 ) = b
 */
public class Solution {
    public static int maximum(int a, int b) {
        long c = (long) a - (long) b;
        int flag = (int) (c >> 63); // 这里一定要是符号右移
        return (1 + flag) * a - flag * b;
    }

    public static void main(String[] args) {
        int a = -73383683;
        int b = -2537;
        System.out.println(maximum(a, b));
    }
}
