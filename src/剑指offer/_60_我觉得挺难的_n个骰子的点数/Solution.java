package 剑指offer._60_我觉得挺难的_n个骰子的点数;

// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
// 输入n，打印出s的所有可能的值出现的概率。
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表
// 这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

import java.util.Arrays;

/**
 * This problem can be solved with dynamic programming!
 */
public class Solution {
    public static double[] twoSum(int n) {
        // dp[0] 不要, 设置便于理解的
        double[][] dp = new double[n + 1][];
        // 一个骰子的情况
        dp[1] = new double[6];
        for (int k = 0; k < 6; k++) {
            dp[1][k] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            // i 个骰子的最小值为 n 个 1 的和，
            // 最大值为 i 个 6 的和
            int min = i, max = 6 * i;
            dp[i] = new double[max - min + 1];
            int p = 0;
            for (int sum = min; sum <= max; sum++) {
                // 此时有 a1, a2, ... , ai 个骰子, 它们之和为 sum.
                // 如果此时 a1 = j, 剩余 i - 1 个数之和要为 sum - j.
                // i - 1 个数的最小值为 i - 1.
                // sum - j >= i - 1 所以 j <= sum - i + 1.
                // i - 1 个数的最大值为 6 * (i - 1).
                // sum - j <= 6 * (i - 1) 所以 j >= sum - 6 * (i - 1).
                for (int j = Math.max(1, sum - 6 * (i - 1)); j <= sum - i + 1 && j <= 6; j++) {
                    int remain = sum - j;
                    int p1 = remain - (i - 1);
                    // 1 / 6.0 : 当前骰子数为 j 的概率
                    // dp[i - 1][p1]: 其余 i - 1 个骰子数总和为 remain 的概率
                    dp[i][p] += (1 / 6.0) * dp[i - 1][p1];
                }
                p++;
            }
        }
        return dp[n];
    }

    public static double[] twoSum1(int n) {
        double[][] dp = new double[n + 1][];
        dp[1] = new double[6];
        for (int k = 0; k < 6; k++) {
            dp[1][k] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            int min = i, max = 6 * i;
            dp[i] = new double[max - min + 1];
            int p = 0;
            for (int sum = min; sum <= max; sum++) {
                for (int j = Math.max(1, sum - 6 * (i - 1)); j <= sum - i + 1 && j <= 6; j++) {
                    int remain = sum - j;
                    int p1 = remain - (i - 1);
                    dp[i][p] += (1 / 6.0) * dp[i - 1][p1];
                }
                p++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(11)));
    }
}
