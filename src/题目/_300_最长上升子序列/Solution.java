package 题目._300_最长上升子序列;

import java.util.Arrays;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int p = Arrays.binarySearch(dp, 0, ans, val);
            p = p < 0 ? -(p + 1) : p;
            dp[p] = val;
            ans = Math.max(ans, p + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(lengthOfLIS(nums));
    }
}
