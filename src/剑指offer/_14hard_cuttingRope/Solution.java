package 剑指offer._14hard_cuttingRope;

public class Solution {
    // 最好的方法
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        } else {
            int i = n / 3;
            int j = n % 3;

            if (j == 1) {
                return (int) (Math.pow(3, i - 1) * 4);
            } else if (j == 0) {
                return (int) (Math.pow(3, i));
            }

            // j == 2
            return (int) (Math.pow(3, i) * j);
        }
    }

    // 动态规划的方法
    public int cuttingRope0(int n) {
        if (n<=3) return n-1;
        int[] dp = new int[n+1];
        dp[2] = 2; dp[3] = 3;

        for (int i = 4; i <= n; i++){
            dp[i] = 2 * dp[i-2] > 3 * dp[i-3] ? 2 * dp[i-2] : 3 * dp[i-3];
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope0(10));
    }
}
