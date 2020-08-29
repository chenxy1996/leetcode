package dp._45_困难_跳跃游戏2.dp;

/**
 * dp 超时了
 */
public class Solution {
    public static int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for(int i = len - 2; i >= 0; i--) {
            int step = nums[i];
            if (step + i >= len - 1) {
                dp[i] = 1;
            } else {
                dp[i] = len;
                for(int j = 1; j <= step; j++) {
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
