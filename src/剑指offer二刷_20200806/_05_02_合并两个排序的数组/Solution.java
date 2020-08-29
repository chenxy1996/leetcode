package 剑指offer二刷_20200806._05_02_合并两个排序的数组;

/**
 * 和 88 题相同
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {1};
        merge(a, 0, b, 1);
    }
}
