package 剑指offer._0_剑指offer二刷_20200806._16_数值的整数次方.记忆之前的计算;

public class Solution {
    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }

        int size = 32;
        double[] dp = new double[size];
        dp[0] = x;

        int p = 1;
        while ((p < size) && ((1L << p) <= b)) {
            dp[p] = dp[p - 1] * dp[p - 1];
            p++;
        }

        int i = p - 1;
        long pow = 1L << i;
        double ans = dp[i];

        for (int j = i - 1; j >= 0; j--) {
            long val = 1L << j;
            if (pow + val == b) {
                ans *= dp[j];
                break;
            } else if (pow + val < b) {
                ans *= dp[j];
                pow += val;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        double x = 1;
        int n = -2147483647;
        System.out.println(Math.pow(x, n));
        System.out.println(myPow(x, n));
    }
}
