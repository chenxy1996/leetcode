package 题目._75_中等有意思_颜色分类._20200820;

import java.util.Arrays;

public class Solution {
    public static void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int l = 0;
        int r = nums.length - 1;
        int p = 0;
        while (p <= r) {
            if (nums[p] == 2) {
                swap(nums, p, r);
                while (r >= 0 && nums[r] == 2) {
                    r--;
                }
            } else if (nums[p] == 0) {
                swap(nums, p, l);
                while(l < nums.length && nums[l] == 0) {
                    l++;
                }
                p = l;
            } else {
                p++;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
