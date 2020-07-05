<<<<<<< HEAD
package 排序专题.选择排序_selectionSort;

import 排序专题.SortTest;
import 排序专题.快速排序_quickSort.QuickSort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pos = 0;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[pos]) {
                    pos = j;
                }
            }
            // 交换
            int temp = nums[pos];
            nums[pos] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 0};
        int[] nums = {5, 5, 6, 2, 7, 3, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println(SortTest.test(SelectionSort::sort));
    }
}
=======
package 排序专题.选择排序_selectionSort;

import 排序专题.SortTest;
import 排序专题.快速排序_quickSort.QuickSort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pos = 0;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[pos]) {
                    pos = j;
                }
            }
            // 交换
            int temp = nums[pos];
            nums[pos] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 0};
        int[] nums = {5, 5, 6, 2, 7, 3, 8, 5, 10};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println(SortTest.test(SelectionSort::sort));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
