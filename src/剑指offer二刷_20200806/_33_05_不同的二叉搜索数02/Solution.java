package 剑指offer二刷_20200806._33_05_不同的二叉搜索数02;

/**
 * 95 题:不同的二叉搜索树
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] += dp[j] * dp[(i - 1) - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}
