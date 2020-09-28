package 题目._0189_旋转数组;

import java.util.Arrays;

public class Solution {
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;

        int count = 0;
        for(int start = 0; count < len; start++) {
            int prev = nums[start];
            int p = start;
            do {
                int next = (p + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                p = next;
                count++;
            } while (p != start);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
