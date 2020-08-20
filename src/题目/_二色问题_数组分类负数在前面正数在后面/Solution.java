package 题目.数组分类负数在前面正数在后面;

import java.util.Arrays;

public class Solution {
    public static void partition(int[] nums) {
        if (nums == null) {
            return;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            while(l <= r && nums[l] < 0) {
                l++;
            }
            while(l <= r && nums[r] > 0) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, 7, -2, -9, 9, 10, -2, -5, 8, 8, 6};
        partition(nums);
        System.out.println(Arrays.toString(nums));
    }
}
