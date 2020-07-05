package dp;

import javax.management.StandardEmitterMBean;
import java.util.Arrays;

public class MaxSalary {
    public static int getMax(int[][] intervals, int[] profits) {
        int[] dp = new int[12];
        // 初始化第一行
        for (int i = 0; i < dp.length; i++) {
            if (i >= intervals[0][1]) {
                dp[i] = profits[0];
            }
        }

        // i 为当前指向的工作
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = new int[12];
            // j 为几点
            for (int j = 0; j < dp.length; j++) {
                int val1 = 0;
                int val2 = 0;

                if (j >= intervals[i][1]) {
                    val1 = dp[intervals[i][0]] + profits[i];
                }

                val2 = dp[j];

                temp[j] = Math.max(val1, val2);
            }

            dp = temp;
        }

//        System.out.println(Arrays.toString(dp));
        return dp[11];
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 5}, {0, 6}, {4, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}};
        int[] profits = {5, 1, 8, 4, 6, 3, 2, 4};
        System.out.println(getMax(intervals, profits));
    }
}
