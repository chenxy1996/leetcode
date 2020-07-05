package 排序专题.插入排序_insertionSort;

import 排序专题.SortTest;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int pos = findPos(nums, 0, i - 1, nums[i]);
            move(nums, pos, i);
        }
    }

    private static int findPos(int[] nums, int left, int right, int target) {
        if (nums[left] >= target) {
            return left;
        }

        if (nums[right] <= target) {
            return right + 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            if (val <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] <= target ? left + 1 : left;
    }

    private static void move(int[] nums, int pos, int targetPos) {
        if (pos == targetPos) {
            return;
        }

        int temp = nums[targetPos];

        for (int i = targetPos; i >= pos && i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[pos] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4};
        int target = 3;
        System.out.println(findPos(nums, 0, nums.length - 1, target));

//        System.out.println(SortTest.test(InsertionSort::sort));
    }
}
