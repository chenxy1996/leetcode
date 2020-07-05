<<<<<<< HEAD
package jianZhiOffer._40_最小的K个数;

import java.util.Arrays;

/**
 * 利用堆排序来做
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        construct(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[0];
            if (i < k - 1) {
                int end = arr.length - 1 - i;
                arr[0] = arr[end];
                adjust(arr, 0, end - 1);
            }
        }
        return res;
    }

    public static void construct(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length - 1);
        }
    }

    public static void adjust(int[] nums, int i, int end) {
        int temp = nums[i];
        int j;
        for (j = i; j <= end;) {
            int k = 2 * j + 1;
            if (k + 1 <= end && nums[k] > nums[k + 1]) {
                k = k + 1;
            }
            if (k <= end && temp > nums[k]) {
                nums[j] = nums[k];
                j = k;
            } else {
                break;
            }
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 7, 1, 2, 9, 5, 4};
        int k = 4;
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, k)));
    }
}
=======
package jianZhiOffer._40_最小的K个数;

import java.util.Arrays;

/**
 * 利用堆排序来做
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        construct(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[0];
            if (i < k - 1) {
                int end = arr.length - 1 - i;
                arr[0] = arr[end];
                adjust(arr, 0, end - 1);
            }
        }
        return res;
    }

    public static void construct(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length - 1);
        }
    }

    public static void adjust(int[] nums, int i, int end) {
        int temp = nums[i];
        int j;
        for (j = i; j <= end;) {
            int k = 2 * j + 1;
            if (k + 1 <= end && nums[k] > nums[k + 1]) {
                k = k + 1;
            }
            if (k <= end && temp > nums[k]) {
                nums[j] = nums[k];
                j = k;
            } else {
                break;
            }
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 7, 1, 2, 9, 5, 4};
        int k = 4;
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, k)));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
