package 面试金典._08_递归问题._11_这道题很典型_硬币;

/**
 * 这道题是组合问题，第一次写的时候正好写出了最错误的代码
 */
public class Solution {
    public int waysToChange(int n) {
        int[] notes = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int note : notes) {
            for (int i = 1; i <= n; i++) {
                if (i - note >= 0) {
                    dp[i] = (dp[i] + dp[i - note]) % 1000000007;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(10));
    }
}
