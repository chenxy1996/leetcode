package jianZhiOffer._11hard_minArray;

public class Solution {
    // 这种解法的时间复杂度为O(n),
    // 如果加以改进，可以采用而方法，将其降为 o(log(n))
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int i = 0, j = 1;
        while (j < numbers.length) {
            if (numbers[j] < numbers[i]) {
                return numbers[j];
            }
            i++;
            j++;
        }

        return numbers[0];
    }

    public int optimalMinArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        // 这里 start < end 和 start <= end 都可以
        while (start <= end) {
            mid = ((end - start) >> 1) + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.println(new Solution().optimalMinArray(nums));
    }
}
