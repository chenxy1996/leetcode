package 面试金典._10_数组问题._11_峰与谷;

import java.util.Arrays;

/**
 * 初见，用了排序算法，不太行
 */
public class Solution {
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int p = 0;
        for (int i = 0; i <= nums.length - 1 - i; i++) {
            tmp[p] = nums[nums.length - 1 - i];
            if (i != nums.length - 1 - i) {
                tmp[p + 1] = nums[i];
            }
            p += 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,8,6,2,3,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
