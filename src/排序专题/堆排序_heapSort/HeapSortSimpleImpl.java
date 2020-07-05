package 排序专题.堆排序_heapSort;

import java.util.Arrays;

// 写得更好，更简单
public class HeapSortSimpleImpl {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        constructHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, i - 1);
        }
    }

    private static void constructHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
    }

    private static void adjustHeap(int[] nums, int i, int e) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k <= e; k = 2 * k + 1) {
            if (k + 1 <= e && nums[k + 1] > nums[k]) {
                k = k + 1;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 0, 2, 4, 2, 10, 1, 6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
