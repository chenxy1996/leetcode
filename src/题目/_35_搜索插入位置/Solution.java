package 题目._35_搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            int val = nums[m];
            if (val >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
