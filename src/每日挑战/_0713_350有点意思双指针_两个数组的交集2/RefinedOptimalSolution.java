package 每日挑战._0713_350有点意思双指针_两个数组的交集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefinedOptimalSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 首先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int p0 = 0, p1 = 0, p = 0;
        while (p0 < nums1.length && p1 < nums2.length) {
            int valP0 = nums1[p0];
            int valP1 = nums2[p1];
            if (valP0 < valP1) {
                p0++;
            } else if (valP0 > valP1) {
                p1++;
            } else {
                ans[p++] = valP0;
                p0++;
                p1++;
            }
        }
        return Arrays.copyOfRange(ans, 0 , p);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(new RefinedOptimalSolution().intersect(nums1, nums2)));
    }
}
