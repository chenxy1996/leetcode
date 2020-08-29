package 剑指offer二刷_20200806._21_调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

public class Solution {
    public static int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            while (l <= r && ((nums[l] & 1) == 1)) {
                l++;
            }
            while (l <= r && ((nums[r] & 1) == 0)) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        nums = exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}
