package 剑指offer二刷_20200806._39_数组中出现次数超过一半的数字.利用快速排序;

public class Solution {
    public static int majorityElement(int[] nums) {
        return partition(nums, 0, nums.length - 1, nums.length / 2);
    }

    private static int partition(int[] nums, int left, int right, int k) {
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
        if (r == k) {
            return nums[r];
        } else if (r < k) {
            return partition(nums, r + 1, right, k);
        } else {
            return partition(nums, left, r, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(majorityElement(nums));
    }
}
