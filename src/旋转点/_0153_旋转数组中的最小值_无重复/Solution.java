package 旋转点._0153_旋转数组中的最小值_无重复;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
