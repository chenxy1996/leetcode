package jianZhiOffer._21_exchange;

import java.util.Arrays;

public class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }

        int i = 0;
        int j = nums.length - 1;
        int temp;

        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }

            while (i < j && nums[j] % 2 == 0) {
                j--;
            }

            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6 ,3, 2, 4, 2, 1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(nums)));
    }
}
