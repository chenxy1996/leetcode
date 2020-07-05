<<<<<<< HEAD
package 排序专题.快速排序_quickSort;

import 排序专题.SortTest;

import java.util.Arrays;

public class QuickSortImpl {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
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

        nums[left] = nums[r];
        nums[r] = pivot;

        sort(nums, left, r - 1);
        sort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 6, 2, 7, 3, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(QuickSortImpl::sort));
    }
}
=======
package 排序专题.快速排序_quickSort;

import 排序专题.SortTest;

import java.util.Arrays;

public class QuickSortImpl {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
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

        nums[left] = nums[r];
        nums[r] = pivot;

        sort(nums, left, r - 1);
        sort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 6, 2, 7, 3, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(QuickSortImpl::sort));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
