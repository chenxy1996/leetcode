package 面试金典._17_动态规划._09_第K个数;

/**
 * 这道题和剑指offer的那道丑数的问题一样
 */
public class Solution {
    public int getKthMagicNumber(int p) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] dp = new int[p];
        dp[0] = 1;
        for (int m = 1; m < p; m++) {
            int val3 = dp[i] * 3;
            int val5 = dp[j] * 5;
            int val7 = dp[k] * 7;
            if (val3 <= val5 && val3 <= val7) {
                dp[m] = val3;
                i++;
            }
            if (val5 <= val3 && val5 <= val7) {
                dp[m] = val5;
                j++;
            }
            if (val7 <= val3 && val7 <= val5) {
                dp[m] = val7;
                k++;
            }
        }
        return dp[p - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getKthMagicNumber(10));
    }
}
