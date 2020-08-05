package dp._416_典型背包问题_我觉得挺难的_分割等和子集;

/**
 * 这道题刚开始做觉得难完全是因为背包的原型问题没有
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum >> 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        if (nums[0] <= sum) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (dp[sum]) {
                return true;
            }
            for (int j = sum; j >= 0; j--) {
                dp[j] = dp[j] || // 不选择当前数
                        (j - nums[i] >= 0 && dp[j - nums[i]]); // 选了当前数
            }
        }
        return dp[sum];
    }
}
