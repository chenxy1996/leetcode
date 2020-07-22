package jianZhiOffer._56_1妙_数组中数字出现的次数;

import java.util.Arrays;

public class OptimalSolution {
    public int[] singleNumbers(int[] nums) {
        int ab = 0;
        for (int num : nums) {
            ab ^= num;
        }
        int mask = ab & (-ab);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(solution.singleNumbers(nums)));
    }
}
