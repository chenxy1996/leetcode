package 剑指offer._16_myPow;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long b = n;

        if (x == 0) {
            return 0;
        }

        // 如果 n < 0
        if (n < 0) {
            x = 1.0 / x;
            b = -b;
        }

        int p;
        while (b != 0) {
            p = (int) (b & 1);
            if (p == 0) {
                res *= 1;
            } else {
                // 此时 p == 1
                res *= x;
            }
            x = x * x;
            b = b >> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, -4));
    }
}
