package 剑指offer二刷_20200806._40_02_数组中的第K个最大元素.利用快排;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        partition(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    private void partition(int[] arr, int left, int right, int p) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[l++];
        while (l <= r) {
            while (l <= r && arr[l] > pivot) {
                l++;
            }
            while (l <= r && arr[r] <= pivot) {
                r--;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[r];
        arr[r] = pivot;
        if (r < p) {
            partition(arr, r + 1, right, p);
        } else if (r > p) {
            partition(arr, left, r, p);
        }
    }

    public static void main(String[] args) {
        int[] nums = {99,99};
        int k = 1;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
