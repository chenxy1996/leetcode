package 排序专题.插入排序无二分查找_insertionSort;

import 排序专题.SortTest;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = 0; j < i; j++) {
                if (temp < nums[j]) {
                    for (int k = i; k > j; k--) {
                        nums[k] = nums[k - 1];
                    }
                    nums[j] = temp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(InsertionSort::sort));
    }
}
