package 难点_二分法._0153_无重复_寻找排序数组的最小值;

public class Solution {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = ((r - l) >> 1) + l;
            if (nums[m] >= nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
