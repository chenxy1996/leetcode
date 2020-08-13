package 剑指offer._0_剑指offer二刷_20200806._16_数值的整数次方.最好的办法;

public class OptimalSolution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        long b = n;
        if (b < 0) {
            b = -n;
            x = 1 / x;
        }

        double ans = 1;
        while (b != 0) {
            int p = (int) (b & 1);
            if (p == 1) { // 奇数
                ans *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return ans;
    }
}
