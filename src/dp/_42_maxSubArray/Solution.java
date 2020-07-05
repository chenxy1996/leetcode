package dp._42_maxSubArray;

import java.util.Arrays;

public class Solution {
    public static int[] maxSubArray(int[] nums) {
        int s = 0;
        int e = 0;
        int max = nums[0];
        int globalMax = nums[0];
        int[] interval = {0, 0};

        return interval;
    }

    /**
     * 如果不需要区间只要最大值
     */
    public static int maxSubArraySum(int[] nums) {
        int beforeSum = nums[0];
        int max = beforeSum;

        for (int i = 1; i < nums.length; i++) {
            if (beforeSum < 0) {
                beforeSum = nums[i];
            } else {
                beforeSum += nums[i];
            }

            max = Math.max(beforeSum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        System.out.println(Arrays.toString(maxSubArray(nums)));
        System.out.println(maxSubArraySum(nums));
    }
}
