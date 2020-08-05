package 难点_二分法._033_无重复_困难_搜索旋转排序数组;

public class Solution {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val == target) {
                return m;
            }
            if (val < nums[r]) { // 说明区间 [m, r] 是严格递增的
                if (val < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[l] <= target && target < val) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5};
        System.out.println(search(nums, 4));
    }
}
