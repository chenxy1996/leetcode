package 难点_二分法._0004_二刷_寻找两个正序数组中的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int med = (len1 + len2) >>> 1;
        if (((len1 + len2) & 1) == 1) {
            return findKthNum(nums1, nums2, med) / 1.0;
        } else {
            return (findKthNum(nums1, nums2, med) + findKthNum(nums1, nums2, med - 1)) / 2.0;
        }
    }

    private int findKthNum(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while(true) {
            if (i >= len1) {
                return nums2[j + k];
            }
            if (j >= len2) {
                return nums1[i + k];
            }
            if (k == 0) {
                return Math.min(nums1[i], nums2[j]);
            }
            if (k == 1) {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else {
                    j++;
                }
                k--;
                continue;
            }
            int half = k / 2;
            int ii = Math.min(i + half - 1, len1 - 1);
            int jj = Math.min(j + half - 1, len2 - 1);
            if (nums1[ii] <= nums2[jj]) {
                k -= ii - i + 1;
                i = ii + 1;
            } else {
                k -= jj - j + 1;
                j = jj + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
