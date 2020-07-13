package 每日挑战._0713_350有点意思双指针_两个数组的交集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这道题，初见写的麻烦了
 */
public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> collection = new ArrayList<>();
        // 首先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] longer = shorter == nums1 ? nums2 : nums1;

        int l = 0;
        int r = shorter.length - 1;
        int left = 0;
        int right = longer.length - 1;

        while (l <= r && left <= right) {
            int min = shorter[l];
            int max = shorter[r];
            if (max < longer[left] || min > longer[right]) {
                break;
            }

            int posMin = find(longer, left, right, min, true);
            int posMax = find(longer, left, right, max, false);

            if (posMin != -1) {
                collection.add(min);
                left = posMin + 1;
            }
            if (l != r && posMax != -1) {
                if (posMax != posMin) {
                    collection.add(max);
                }
                right = posMax - 1;
            }

            l++;
            r--;
        }

        int[] res = new int[collection.size()];
        int i = 0;
        for (Integer each : collection) {
            res[i++] = each;
        }
        return res;
    }

    private static int find(int[] nums, int left, int right, int target, boolean leftBorder) {
        int l = left;
        int r = right;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM > target || (valM == target && leftBorder)) {
                r = m - 1;
            } else if (valM < target || valM == target) {
                l = m + 1;
            }
        }
        if (leftBorder) {
            return l <= right && nums[l] == target ? l : -1;
        } else {
            return r >= left && nums[r] == target ? r : -1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
