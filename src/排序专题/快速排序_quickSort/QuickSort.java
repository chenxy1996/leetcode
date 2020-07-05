package 排序专题.快速排序_quickSort;

import jdk.swing.interop.SwingInterOpUtils;
import 排序专题.SortTest;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSortFromRight(nums, 0, nums.length - 1);
    }

    private static void quickSortFromLeft(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = nums[l++];

        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }

            while (l <= r && nums[r] >= pivot) {
                r--;
            }

            if (l < r) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            }
        }

        // 此时 r = l - 1
        nums[left] = nums[r];
        nums[r] = pivot;

        quickSortFromLeft(nums, left, r - 1);
        quickSortFromLeft(nums, r + 1, right);
    }

    public static void quickSortFromRight(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = nums[l++];

        while (l <= r) {
            while (l <= r && nums[r] >= pivot) {
                r--;
            }

            while (l <= r && nums[l] < pivot) {
                l++;
            }

            if (l < r) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            }
        }

        nums[left] = nums[r];
        nums[r] = pivot;

        quickSortFromRight(nums, left, r - 1);
        quickSortFromRight(nums, r + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {2, 0};
//        int[] nums = {5, 5, 6, 2, 7, 3, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println(SortTest.test(QuickSort::sort));
    }
}
