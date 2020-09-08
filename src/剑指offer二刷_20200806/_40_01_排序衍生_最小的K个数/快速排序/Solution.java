package 剑指offer二刷_20200806._40_01_排序衍生_最小的K个数.快速排序;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        partition(arr, 0, arr.length - 1, k - 1);
        return Arrays.copyOf(arr, k);
    }

    private void partition(int[] nums, int left, int right, int k) {
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
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[r];
        nums[r] = pivot;
        if (r < k) {
            partition(nums, r + 1, right, k);
        } else if (r > k) {
            partition(nums, left, r, k);
        }
    }
}
