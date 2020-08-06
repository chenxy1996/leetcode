package 剑指offer._53_1_统计一个数字在排序数组中出现的次数;

public class Solution {
    // 直接找到左右边界就可以, inclusive
    public static int search(int[] nums, int target) {
        int l1 = 0;
        int l2 = 0;
        int r1 = nums.length - 1;
        int r2 = r1;
        while (l1 <= r1 || l2 <= r2) {
            // 左边界
            if (l1 <= r1) {
                int m1 = l1 + (r1 - l1) / 2;
                int valM1 = nums[m1];
                if (valM1 >= target) {
                    r1 = m1 - 1;
                } else {
                    l1 = m1 + 1;
                }
            }
            // 右边界
            if (l2 <= r2) {
                int m2 = l2 + (r2 - l2) / 2;
                int valM2 = nums[m2];
                if (valM2 <= target) {
                    l2 = m2 + 1;
                } else {
                    r2 = m2 - 1;
                }
            }
        }

        return r2 >= l1 ? r2 - l1 + 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 12;
        System.out.println(search(nums, target));
    }
}
