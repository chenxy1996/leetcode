package 题目._29_我觉得挺难_Med有溢出情况考虑_两数相除;


public class OptimalSolution {
    /**
     * 为了防止负数转换为正数时候的溢出，将正数转为负数来做
     */
    public static int divide(int dividend, int divisor) {
        boolean flag = (dividend >>> 31) == (divisor >>> 31); // 是否同号
        // 将 dividend 和 divisor 都转换为符号
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        int res = divideHelper(dividend, divisor);
        return flag ? (res == Integer.MIN_VALUE ? Integer.MAX_VALUE : -res) : res;
    }

    private static int divideHelper(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int temp = divisor;
        int res = -1;
        int tmp;
        // 判断 divisor 的两倍是否小于 Integer.MIN_VALUE, 溢出就为正数
        while ((tmp = (divisor << 1)) < 0 && tmp > dividend) {
            res = res << 1;
            divisor = divisor << 1;
        }
        return res + divideHelper(dividend - divisor, temp);
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = -3;
        System.out.println(divide(dividend, divisor));
        System.out.println(dividend / divisor);
    }
}
