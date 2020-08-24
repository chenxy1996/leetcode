package 难点_二分法._04_02_寻找两个正序数组第K小的数字;

public class MySolution {
    public static int getKth(int[] nums1, int[] nums2, int k) {
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int cnt = k - 1;
        int i = 0;
        int j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (cnt > 1 && i < len1 && j < len2) {
            int d = cnt / 2;
            int ii, jj;
            if (i + d - 1 < len1) {
                ii = i + d - 1;
            } else {
                ii = len1 - 1;
            }
            if (j + d - 1 < len2) {
                jj = j + d - 1;
            } else {
                jj = len2 - 1;
            }
            int val1 = nums1[ii];
            int val2 = nums2[jj];
            if (val1 <= val2) {
                cnt -= ii - i + 1;
                i = ii + 1;
            } else {
                cnt -= jj - j + 1;
                j = jj + 1;
            }
        }
        if (i >= nums1.length) {
            return nums2[j + cnt];
        }
        if (j >= nums2.length) {
            return nums1[i + cnt];
        }
        if (nums1[i] <= nums2[j]) {
            i++;
        } else {
            j++;
        }
        return Math.min(
                i < len1 ? nums1[i] : Integer.MIN_VALUE,
                j < len2 ? nums2[j] : Integer.MIN_VALUE
        );
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4 ,6, 6 ,7};
        int[] b = {-1, 0, 0, 1, 3, 6, 8, 8};
        int k = 5;
        System.out.println(getKth(a, b, k));
    }
}
