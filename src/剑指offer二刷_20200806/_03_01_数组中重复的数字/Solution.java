package 剑指offer._0_剑指offer二刷_20200806._03_01_数组中重复的数字;

public class Solution {
    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int zeroCnt = 0;
        for (int num : nums) { // 判断是否在 0 ~ n - 1 范围之内
            if (num < 0 || num >= nums.length) {
                return -1;
            }
            if (num == 0) {
                zeroCnt++;
            }
        }
        if (zeroCnt >= 2) { //判断是 0 是否重复
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int valP = Math.abs(val);
            if (nums[valP] < 0) {
                return valP;
            } else {
                nums[valP] = -nums[valP];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 0, 1};
        int[] test2 = {0, 1, 2, 3, 3};
        int[] test3 = {2, 3, 1, 0, 2, 5, 3};
        int[] test4 = {1, 1, 1};
        int[] test5 = {0, 1, 2};

        System.out.println(findRepeatNumber(test5));
    }
}
