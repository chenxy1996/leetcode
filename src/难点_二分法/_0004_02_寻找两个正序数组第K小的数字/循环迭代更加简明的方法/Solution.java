package 难点_二分法._0004_02_寻找两个正序数组第K小的数字.循环迭代更加简明的方法;

public class Solution {
    public static int getKth(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (true) {
            if (i == len1) {
                return nums2[j + k - 1];
            }
            if (j == len2) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[i]);
            }
            int half = k / 2;
            int ii = Math.min(i + half, len1) - 1;
            int jj = Math.min(j + half, len2) - 1;
            int val1 = nums1[ii];
            int val2 = nums2[jj];
            if (val1 <= val2) {
                k -= ii - i + 1;
                i = ii + 1;
            } else {
                k -= jj - j + 1;
                j = jj + 1;
            }
        }
    }
}
