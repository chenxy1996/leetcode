package 排序专题.堆排序_heapSort;

import 排序专题.SortTest;

import java.util.Arrays;

public class HeapSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        construct(nums);
        for (int i = 0; i < nums.length; i++) {
            int end = nums.length - 1 - i;
            swap(nums, 0, end);
            adjustTree(nums, 0, end - 1);
        }
    }

    private static void construct(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustTree(nums, i, nums.length - 1);
        }
    }

    private static void constructTree(int[] nums) {
        constructTree(nums, 0);
    }

    // 利用递归的方式来初始化堆
    private static void constructTree(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return;
        }
        // 左子树
        constructTree(nums, 2 * i + 1);
        // 右子树
        constructTree(nums, 2 * i + 2);
        adjustTree(nums, i, nums.length - 1);
    }
    
    private static void adjustTree(int[] nums, int i, int end) {
        for (int j = i; j <= end;) {
            int max = j;
            max = 2 * j + 1 <= end ? compare(nums, 2 * j + 1, max) : max;
            max = 2 * j + 2 <= end ? compare(nums, 2 * j + 2, max) : max;
            if (j != max) {
                swap(nums, j, max);
                j = max;
            } else {
                break;
            }
        }
    }

    private static int compare(int[] nums, int a, int b) {
        return nums[a] > nums[b] ? a : b;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 2, 4, 3, 1, 2, 9, 10, 0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(HeapSort::sort));
    }
}
