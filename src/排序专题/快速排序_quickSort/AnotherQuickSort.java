package 排序专题.快速排序_quickSort;


import 排序专题.SortTest;

import java.util.Arrays;

// 选择别的位置的 pivot
// 选择区间最后的数字作为 pivot
public class AnotherQuickSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSortFromLeft(nums, 0, nums.length - 1);
    }


    private static void quickSortFromRight(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = nums[r--];

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

        nums[right] = nums[l];
        nums[l] = pivot;

        quickSortFromRight(nums, left, l - 1);
        quickSortFromRight(nums, l + 1, right);
    }

    private static void quickSortFromLeft(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = nums[r--];

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

        nums[right] = nums[l];
        nums[l] = pivot;

        quickSortFromLeft(nums, left, l - 1);
        quickSortFromLeft(nums, l + 1, right);
    }

    public static void main(String[] args) {
//        int[] nums = {0};
        int[] nums = {5, 5, 6, 2, 7, 3, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));

//        System.out.println(SortTest.test(AnotherQuickSort::sort));
    }
}
