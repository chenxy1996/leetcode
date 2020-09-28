package dp._0213_打家劫舍2;

public class Solution {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];

        dp[1] = nums[0];
        for(int i = 2; i < len; i++) {
            int val = nums[i - 1];
            dp[i] = Math.max(dp[i - 2] + val, dp[i - 1]);
        }
        int ans1 = dp[len - 1];

        dp[len - 1] = 0;
        dp[len - 2] = nums[len - 1];
        for(int i = len - 3; i >= 0; i--) {
            int val = nums[i + 1];
            dp[i] = Math.max(dp[i + 2] + val, dp[i + 1]);
        }
        int ans2 = dp[0];

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(rob(nums));
    }
}
