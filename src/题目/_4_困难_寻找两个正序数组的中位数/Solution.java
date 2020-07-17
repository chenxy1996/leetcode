package 题目._4_困难_寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int left = (len1 + len2 - 1) >> 1; // 中位数左边的数字数量

        int right = left; // 中位数右边的数字数量
        int l = 0, r = 0; // 已经被筛选出的左右两边的数字数量

        int s1 = 0, s2 = 0;
        int e1 = len1 - 1, e2 = len2 - 1;

        while (l <= left || r <= right) {
            int m1 = s1 + (e1 - s1) / 2;
            int m2 = s2 + (e2 - s2) / 2;
            int valM1 = nums1[m1];
            int valM2 = nums2[m2];
            if (valM1 >= valM2) {

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {0,2,10};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
