package 面试金典._16_数学问题._17_连续数列;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + val : val;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
