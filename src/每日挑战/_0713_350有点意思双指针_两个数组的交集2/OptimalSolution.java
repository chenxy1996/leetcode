package 每日挑战._0713_350有点意思双指针_两个数组的交集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 首先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] shorter = nums1.length <= nums2.length ? nums1 : nums2;
        int[] longer = shorter == nums1 ? nums2 : nums1;
        List<Integer> list = new ArrayList<>();
        int l1 = 0, r1 = shorter.length - 1;
        int l2 = 0, r2 = longer.length - 1;
        while (l1 <= r1 && l2 <= r2) {
            int valL1 = shorter[l1], valR1 = shorter[r1];
            int valL2 = longer[l2], valR2 = longer[r2];
            if (valL1 < valL2) {
                l1++;
            } else if (valL1 > valL2) {
                l2++;
            } else {
                list.add(valL1);
                l1++;
                l2++;
            }
            if (l1 > r1) {
                break;
            }
            if (valR1 < valR2) {
                r2--;
            } else if (valR1 > valR2) {
                r1--;
            } else {
                list.add(valR1);
                r1--;
                r2--;
            }
        }
        int[] ans = new int[list.size()];
        int p = 0;
        for (Integer integer : list) {
            ans[p++] = integer;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1,1,1};
        System.out.println(Arrays.toString(new OptimalSolution().intersect(nums1, nums2)));
    }
}
