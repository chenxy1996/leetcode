package 排序专题._20200809.快速排序;

import 排序专题.SortTest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AnotherQuickSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = nums[l++];
        while (l <= r) {
            while (l <= r && nums[l] <= pivot) {
                l++;
            }
            while (l <= r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[r];
        nums[r] = pivot;
        sort(nums, left, r - 1);
        sort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 2, -1, 0, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
//        SortTest.test(AnotherQuickSort::sort);
    }
}
