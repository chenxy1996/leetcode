package 剑指offer._0_剑指offer二刷_20200806._03_数组中重复的数字;

public class Solution {
    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (nums[Math.abs(val)] < 0) {
                return Math.abs(val);
            } else {
                nums[Math.abs(val)] = -nums[Math.abs(val)];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 0, 1};
        int[] test2 = {0, 1, 2, 3, 3};
        int[] test3 = {2, 3, 1, 0, 2, 5, 3};
        int[] test4 = {1, 1, 1};
        int[] test5 = {0, 1, 2, 7};

        System.out.println(findRepeatNumber(test5));
    }
}
