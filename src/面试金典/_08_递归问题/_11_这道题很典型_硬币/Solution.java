package 面试金典._08_递归问题._11_硬币;

/**
 * 这道题是有重复
 */
public class Solution {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(10));
    }
}
