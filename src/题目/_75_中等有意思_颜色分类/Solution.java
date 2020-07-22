package 题目._75_中等有意思_颜色分类;

import java.util.Arrays;

public class Solution {
    public static void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            int val = nums[i];
            if (val == 0) {
                swap(nums, i, p0);
                p0++;
            } else if (val == 2) {
                swap(nums, i, p2);
                i--;
                p2--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 1, 2, 0, 0, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
