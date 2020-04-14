package jianZhiOffer._10_0_fibonacci;

public class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // iteration
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;

        for (int i = 2, temp; i <= n; i++) {
            temp = b;
            b =  a + b;
            a = temp;
        }

        return b;
    }

    public static void main(String[] args) {
            System.out.println(new Solution().fib1(45));
    }
}
