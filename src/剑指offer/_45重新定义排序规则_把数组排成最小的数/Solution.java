package 剑指offer._45重新定义排序规则_把数组排成最小的数;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    // 快排 + 定义新的比较规则
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).mapToObj(x -> String.valueOf(x)).collect(Collectors.joining());
    }

    private static int compare(int a, int b) {
        long ab = Long.parseLong(String.valueOf(a) + b);
        long ba = Long.parseLong(String.valueOf(b) + a);
        return ab < ba ? 1 : ((ab == ba) ? 0 : -1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = nums[l++];
        while (l <= r) {
            while (l <= r && compare(nums[l], pivot) > 0) {
                l++;
            }
            while (l <= r && compare(pivot, nums[r]) >= 0) {
                r--;
            }
            if (l < r) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
            }
        }
        nums[left] = nums[r];
        nums[r] = pivot;
        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 1};
        System.out.println(solution.minNumber(nums));
    }
}
