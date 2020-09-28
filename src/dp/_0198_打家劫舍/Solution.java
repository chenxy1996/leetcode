package dp._0198_打家劫舍;

public class Solution {
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][2];

        dp[0] = new int[] {0, nums[0]};
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        nums[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }
}
