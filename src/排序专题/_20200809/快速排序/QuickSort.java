package 排序专题._20200809.快速排序;

import java.util.Arrays;

/**
 * 选择区间最左边的作为 pivot
 */
public class QuickSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = nums[l];
        int s = l + 1;
        int e = r;
        while (s <= e) {
            while (s <= e && nums[s] <= pivot) {
                s++;
            }
            while (s <= e && nums[e] > pivot) {
                e--;
            }
            if (s < e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
            }
        }
        nums[l] = nums[e];
        nums[e] = pivot;

        sort(nums, l, e - 1);
        sort(nums, e + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = {9, Integer.MIN_VALUE, Integer.MAX_VALUE};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
