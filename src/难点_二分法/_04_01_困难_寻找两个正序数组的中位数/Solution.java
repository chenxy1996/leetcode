package 难点_二分法._04_01_寻找两个正序数组的中位数;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenSum = nums1.length + nums2.length;
        if ((lenSum & 1) == 0) {
            return (getKth(nums1, nums2, lenSum / 2) + getKth(nums1, nums2, lenSum / 2 + 1)) / 2.0;
        } else {
            return getKth(nums1, nums2, lenSum / 2 + 1);
        }
    }

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

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
