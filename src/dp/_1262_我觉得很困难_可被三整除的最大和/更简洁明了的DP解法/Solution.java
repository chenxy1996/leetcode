package dp._1262_我觉得很困难_可被三整除的最大和.更简洁明了的DP解法;

public class Solution {
    public static int maxSumDivThree(int[] nums) {
        int[] dp = {0, 0, 0};
        for(int num : nums) {
            int[] temp = new int[3];
            for(int i = 0; i < 3; i++) {
                temp[i] += dp[i] + num;
            }
            for(int i = 0; i < 3; i++) {
                int mod = temp[i] % 3;
                dp[mod] = Math.max(dp[mod], temp[i]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }
}
