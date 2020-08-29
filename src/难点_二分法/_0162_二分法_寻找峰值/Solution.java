package 难点_二分法._0162_二分法_寻找峰值;

/**
 * 初见写得很垃圾，虽然通过了
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        if (l == r) {
            return 0;
        }
        while (l <= r) {
            int m = (r - l) / 2 + l;
            int val = nums[m];
            if (m == 0) {
                if (val > nums[m + 1]) {
                    return m;
                } else {
                    l = m + 1;
                }
            } else if (m == nums.length - 1) {
                if (val > nums[m - 1]) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m - 1] < val && val > nums[m + 1]) {
                    return m;
                } else if (nums[m - 1] < val && val < nums[m + 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
