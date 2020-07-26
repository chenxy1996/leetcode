package 题目._371_两整数之和;

/**
 * 不使用 '+' 和 '-' 。
 */
public class Solution {
    public static int getSum(int a, int b) {
        while (a != 0) {
            int temp = a & b;
            b = a ^ b;
            a = temp << 1;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 3));
    }
}
