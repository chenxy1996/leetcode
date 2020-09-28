package 旋转点.旋转数组中的最小值_有重复;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = ((r - l) >> 1) + l;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] == nums[r]) {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 1, 3};
        System.out.println(solution.findMin(nums));
    }
}
