<<<<<<< HEAD
package 排序专题.Shell排序_shellSort;

import 排序专题.SortTest;
import 排序专题.View;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ShellSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        int step = nums.length / 2;
        step = step > 0 ? step : 1;
        while (step > 0) {
            for (int i = 0; i < step; i++) {
                shellSort(nums, i, step);

                // 可视化
                // ------------------------------------------
                int start = i;
                int finalStep = step;
                IntStream stream = IntStream.iterate(start, num -> num < nums.length, num -> num + finalStep);
                View.viewArray(nums, stream.toArray());
                // ------------------------------------------
            }
            step = step >> 1;
        }
    }

    private static void shellSort(int[] nums, int start, int step) {
        for (int i = start; i < nums.length; i += step) {
            int target = nums[i];
            int pos = findPos(nums, start, i - step, step, target);
            pos = pos >= 0 ? pos : i;
            insert(nums, pos, step, i - step, target);
        }
    }

    private static int findPos(int[] nums, int start, int end, int step, int target) {
        int l = 0;
        int r = (end - start) / step;
        end = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int m1 = m * step + start;
            int valM = nums[m1];
            if (valM <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l <= end ? l * step + start : -1;
    }

    private static void insert(int[] nums, int pos, int step, int end, int target) {
        for (int i = end; i >= pos; i -= step) {
            nums[i + step] = nums[i];
        }
        nums[pos] = target;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 2, 1, 12, 0, 7, 8, 3, 2, 2, 4, 9, 5, 5, 6, 12};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(ShellSort::sort));
    }
}
=======
package 排序专题.Shell排序_shellSort;

import 排序专题.SortTest;
import 排序专题.View;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ShellSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        int step = nums.length / 2;
        step = step > 0 ? step : 1;
        while (step > 0) {
            for (int i = 0; i < step; i++) {
                shellSort(nums, i, step);

                // 可视化
                // ------------------------------------------
                int start = i;
                int finalStep = step;
                IntStream stream = IntStream.iterate(start, num -> num < nums.length, num -> num + finalStep);
                View.viewArray(nums, stream.toArray());
                // ------------------------------------------
            }
            step = step >> 1;
        }
    }

    private static void shellSort(int[] nums, int start, int step) {
        for (int i = start; i < nums.length; i += step) {
            int target = nums[i];
            int pos = findPos(nums, start, i - step, step, target);
            pos = pos >= 0 ? pos : i;
            insert(nums, pos, step, i - step, target);
        }
    }

    private static int findPos(int[] nums, int start, int end, int step, int target) {
        int l = 0;
        int r = (end - start) / step;
        end = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int m1 = m * step + start;
            int valM = nums[m1];
            if (valM <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l <= end ? l * step + start : -1;
    }

    private static void insert(int[] nums, int pos, int step, int end, int target) {
        for (int i = end; i >= pos; i -= step) {
            nums[i + step] = nums[i];
        }
        nums[pos] = target;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 2, 1, 12, 0, 7, 8, 3, 2, 2, 4, 9, 5, 5, 6, 12};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(ShellSort::sort));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
