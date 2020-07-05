package 排序专题.快速排序_quickSort;

import 排序专题.SortTest;
import 排序专题.归并排序_mergeSort.MergeSort;

import java.util.Arrays;

public class QuickSort1 {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort1(nums, 0, nums.length - 1);
    }


    // 这里先移动的是左边的指针就会麻烦一些
    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;

        // 取区间最左边的数作为 pivot
        int pivot = nums[l++];

        while (l <= r) {
            // 区间左边大于或者等于 pivot 的第一个位置
            while (l <= r && nums[l] < pivot) {
                l++;
            }

            // 区间右边小于 pivot 的第一个位置
            while (l <= r && nums[r] >= pivot) {
                r--;
            }

            if (l < r) {
                int temp = nums[r];
                nums[r--] = nums[l];
                nums[l++] = temp;
            }
        }

        nums[left] = nums[r];
        nums[r] = pivot;

        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }

    // 先移动右边的指针会简单一些
    private static void quickSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = nums[l];

        while (l != r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }

            while (l < r && nums[l] <= pivot) {
                l++;
            }

            if (l != r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        nums[left] = nums[l];
        nums[l] = pivot;

        quickSort1(nums, left, l - 1);
        quickSort1(nums, l + 1, right);
    }

    public static void main(String[] args) {
        Boolean res = SortTest.test(QuickSort1::sort);
        System.out.println(res);
    }
}
