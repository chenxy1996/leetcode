package 题目._0283_移动零;

public class Solution {
    public static void moveZeroes(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
