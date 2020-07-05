package dp._打家劫舍问题;

import org.w3c.dom.ls.LSOutput;

public class Solution {
    public static int max(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int val1 = 0;
            int val2 = 0;

            if (i - 2 >= 0) {
                val1 = dp[i - 2] + nums[i];
            } else {
                val1 = nums[i];
            }

            val2 = dp[i - 1];

            dp[i] = Math.max(val1, val2);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 2, 4, 1, 7, 8, 3}));
    }
}
