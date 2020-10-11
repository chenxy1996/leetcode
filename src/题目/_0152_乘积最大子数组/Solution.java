package 题目._0152_乘积最大子数组;

/**
 * 这道题和那个最长被 3 整除子数组差不多的思路
 */
public class Solution {
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(nums[i], Math.max(nums[i] * mx, nums[i] * mn));
            min = Math.min(nums[i], Math.min(nums[i] * mx, nums[i] * mn));
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        System.out.println(maxProduct(nums));
    }
}
