package dp._1262_我觉得很困难_可被三整除的最大和;

public class Solution {
    public static int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int i = 0 ; i < nums.length ; i ++){
            int mod = nums[i] % 3;
            int a = dp[(3 + 0 - mod) % 3];
            int b = dp[(3 + 1 - mod) % 3];
            int c = dp[(3 + 2 - mod) % 3];
            if (a!=0 || mod == 0) dp[0] = Math.max(dp[0], a + nums[i]);
            if (b!=0 || mod == 1) dp[1] = Math.max(dp[1], b + nums[i]);
            if (c!=0 || mod == 2) dp[2] = Math.max(dp[2], c + nums[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        System.out.println(maxSumDivThree(nums));
    }
}
