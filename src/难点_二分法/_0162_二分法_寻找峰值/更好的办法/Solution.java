package 难点_二分法._0162_二分法_寻找峰值.更好的办法;

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = (r - l) / 2 + l;
            int val = nums[m];
            if (val < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
