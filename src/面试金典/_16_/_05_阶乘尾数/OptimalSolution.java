package 面试金典._16_._05_阶乘尾数;

public class OptimalSolution {
    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }
}
