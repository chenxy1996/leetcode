package dp.MaxStolenValue;

import java.util.*;

public class Solution {
    public static class DfsSolution {
        public int getMaxValue(int[] weights, int[] values, int capacity) {
            return recur(weights, values, capacity, 0);
        }

        private int recur(int[] weights, int[] values, int capacity, int start) {
            if (capacity == 0) {
                return 0;
            }

            if (capacity < 0) {
                return -1;
            }

            int max = -1;
            for (int i = start; i < weights.length; i++) {
                int temp = recur(weights, values, capacity - weights[i], i + 1);
                if (temp >= 0) {
                    max = Integer.max(temp + values[i], max);
                }
            }

            return max > 0 ? max : -1;
        }
    }


    public static class DfsSolution1 {
        public int getMaxValue(int[] weights, int[] values, int capacity) {
            return recur(weights, values, capacity, 0);
        }

        private int recur(int[] weights, int[] values, int capacity, int p) {
            if (p >= weights.length) {
                return 0;
            }

            if (capacity >= weights[p]) {
                int val1 = recur(weights, values, capacity, p + 1);
                int val2 = recur(weights, values, capacity - weights[p], p + 1) + values[p];
                return Math.max(val1, val2);
            } else {
                return recur(weights, values, capacity, p + 1);
            }
        }
    }

    public static class DpSolution {
        public int getMaxValue(int[] weights, int[] values, int capacity) {
            int[][] dp = new int[weights.length][capacity + 1];

            // 初始化 dp 这个二维数组
            for (int i = 0; i < dp[0].length; i++) {
                if (i >= weights[dp.length - 1]) {
                    dp[dp.length - 1][i] = values[dp.length - 1];
                } else {
                    dp[dp.length - 1][i] = 0;
                }
            }

            for (int i = dp.length - 2; i >= 0; i--) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (j < weights[i]) {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - weights[i]] + values[i]);
                    }
                }
            }

            System.out.println(Arrays.deepToString(dp));

            return dp[0][capacity];
        }
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 8};

        DpSolution dpSolution = new DpSolution();
        System.out.println(dpSolution.getMaxValue(weights, values, 8));
    }
}
