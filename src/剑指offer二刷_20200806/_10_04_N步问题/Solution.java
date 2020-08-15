package 剑指offer._0_剑指offer二刷_20200806._10_04_N步问题;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。。。也可以跳上 n 级台阶。
 * 可以证明为 2 ** (n - 1);
 */
public class Solution {
    public static int waysToStep(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    public static int waysToStep0(int n) {
        return 1 << (n - 1);
    }

    public static void main(String[] args) {
        System.out.println(waysToStep0(7));
    }
}
