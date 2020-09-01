package 题目._873_dp_最长的斐波那契子序列的长度.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * 这道题目动态规划速度耗时也很长
 */
public class Solution {
    public static int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int ans = 0;
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.put(A[i], i);
        }
        int[][] dp = new int[len - 1][len];
        for(int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int target = A[j] - A[i];
                int p = map.getOrDefault(target, -1);
                if (p >= 0 && p < i) { // 这个 p < i 一定要加上
                    dp[i][j] = dp[p][i] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans > 0 ? ans + 2 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(lenLongestFibSubseq(nums));
    }
}
