package 剑指offer._0_剑指offer二刷_20200806._16_01_数值的整数次方.不记忆之前的计算;

/**
 * 这个超时了
 */
public class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        int pow = 1;
        double ans = x;
        while (pow * 2 <= b) {
           ans = ans * ans;
           pow = pow * 2;
        }
        if (pow == b) {
            return ans;
        } else {
            return ans * myPow(x, (int) (b - pow));
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
