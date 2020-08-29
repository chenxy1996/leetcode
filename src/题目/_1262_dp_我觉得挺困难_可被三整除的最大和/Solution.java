package 题目._1262_dp_我觉得挺困难_可被三整除的最大和;

import java.util.Arrays;

public class Solution {
    public static int maxSumDivThree(int[] nums) {
        int[] dp = {0, 0, 0};
        for(int num : nums) {
            int[] temp = Arrays.copyOf(dp, 3);
            for(int i = 0; i < 3; i++) {
                int mod = (dp[i] + num) % 3;
                temp[mod] = Math.max(temp[mod], Math.max(dp[mod], dp[i] + num));
            }
            dp = temp;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        System.out.println(maxSumDivThree(nums));
    }
}
