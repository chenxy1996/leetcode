package jianZhiOffer._56_1妙_数组中数字出现的次数;

import java.util.Arrays;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int ab = 0;
        for (int i = 0; i < nums.length; i++) {
            ab ^= nums[i];
        }
        int mask = 1;
        for (; ab > 0; ab = ab >> 1) {
            int bit = ab & 1;
            if (bit == 1) {
                break;
            } else {
                mask <<= 1;
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if ((val & mask) == 0) {
                a ^= val;
            } else {
                b ^= val;
            }
        }
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, 2, 4, 2, 3, 3, 9};
        System.out.println(Arrays.toString(solution.singleNumbers(nums)));
    }
}
