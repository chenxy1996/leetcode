package jianZhiOffer._57_2有一个非常好的方法_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 这道题应该是一道可以归为数学内的题目
    public static int[][] findContinuousSequence(int target) {
        List<int[]> store = new ArrayList<>();
        int n = (int) Math.sqrt(2 * target); // 最大可能连续正整数数量
        int s = 1;
        int i = n;
        while (i >= 2) {
            double sum = i * s + ((i - 1) / 2.0) * i;
            if (sum == target) {
                int[] nums = new int[i];
                for (int j = 0; j < i; j++) {
                    nums[j] = s + j;
                }
                store.add(nums);
                i--;
            } else if (sum < target) {
                s++;
            } else if (sum > target) {
                i--;
            }
        }

        return store.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int target = 15;
        System.out.println(Arrays.deepToString(findContinuousSequence(target)));
    }
}
