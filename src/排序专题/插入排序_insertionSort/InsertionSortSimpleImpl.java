package 排序专题.插入排序_insertionSort;

import 排序专题.SortTest;

import java.util.Arrays;

public class InsertionSortSimpleImpl {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int pos = findPos(nums, 0, i - 1, nums[i]);
            pos = pos >= 0 ? pos : i;
            insert(nums, pos, i);
        }
    }

    // 查找区间 [l, r] 内的大于 target 的第一个位置
    private static int findPos(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l <= right ? l : -1;
    }

    private static void insert(int[] nums, int pos, int r) {
        int temp = nums[r];
        for (int i = r; i > pos; i--) {
            nums[i] = nums[i - 1];
        }
        nums[pos] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortTest.test(InsertionSortSimpleImpl::sort));
    }
}
