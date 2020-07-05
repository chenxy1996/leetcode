package 排序专题.Shell排序无二分查找_shellSort;

import 排序专题.SortTest;
import 排序专题.插入排序无二分查找_insertionSort.InsertionSort;

import java.util.Arrays;

public class ShellSort {
    public static void sort(int[] nums) {
        int step = nums.length / 2;
        while (true) {
            for (int i = 0; i < step; i++) {
                for (int j = i; j < nums.length; j += step) {
                    int target = nums[j];
                    for (int k = i; k < j; k += step) {
                        if (target < nums[k]) {
                            for (int n = j; n > k; n -= step) {
                                nums[n] = nums[n - step];
                            }
                            nums[k] = target;
                            break;
                        }
                    }
                }
            }
            if (step == 1) {
                break;
            } else {
                step = step >> 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 2, 0, 3, 2, 2, 9, 7, 3, 4, 8, 5, 0, 1, 4, 6, 7, 11, 13, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(InsertionSort::sort));
    }
}
