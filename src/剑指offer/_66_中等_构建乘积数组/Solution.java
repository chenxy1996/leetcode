package 剑指offer._66_中等_构建乘积数组;

// 不能使用除法

import java.util.Arrays;

/**
 * 这道题和 leetcode 238 题目是一致的
 * 分成上下两个三角形来做
 * 初见：思路没有理清楚, 所花费时间十分长！！！！
 */
public class Solution {
    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            int num1 = a[1 + i]; // 上三角形
            int num2 = a[len - 2 - i]; // 下三角形
            for (int j = 0; j <= i; j++) {
                ans[j] *= num1;
                ans[len -1 - j] *= num2;
            }
        }

        return ans;
    }

    public static int[] constructArr1(int[] nums) {
        int len = nums.length;
        int[] numsns = new int[len];
        for (int i = 0; i < len; i++) {
            numsns[i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            int num1 = nums[1 + i]; // 上三角形
            int num2 = nums[len - 2 - i]; // 下三角形
            for (int j = 0; j <= i; j++) {
                numsns[j] *= num1;
                numsns[len -1 - j] *= num2;
            }
        }

        return numsns;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(constructArr(nums)));
    }
}
