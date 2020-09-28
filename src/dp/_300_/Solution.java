package dp._300_;

import java.util.Arrays;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = 0;
        int r = 1;
        for(int i = 1; i < len; i++) {
            int p = Arrays.binarySearch(dp, 0, r, nums[i]);
            p = p < 0 ? -(p + 1) : p;
            dp[p] = nums[i];
            if (p == r) {
                r++;
            }
            ans = Math.max(ans, r);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
