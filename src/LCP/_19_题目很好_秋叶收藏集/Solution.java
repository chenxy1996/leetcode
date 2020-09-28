package LCP._19_题目很好_秋叶收藏集;

public class Solution {
    public static int minimumOperations(String leaves) {
        char[] cs = leaves.toCharArray();
        int len = cs.length;
        int[] f = new int[len];
        if (cs[0] == 'r') {
            f[0] = 1;
        }
        for(int i = 1; i < len; i++) {
            f[i] = f[i - 1] + (cs[i] == 'r' ? 1 : 0);
        }
        int[] dp = new int[len];

        int min = Integer.MAX_VALUE;
        for(int i = len - 1; i >= 1; i--) {
            int val = 2 * f[i - 1] - i;
            min = Math.min(min, val);
            dp[i] = min;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < len - 1; i++) {
            int val = i - 2 * f[i - 1] + dp[i + 1];
            ans = Math.min(ans, val);
        }

        return ans + len - f[len - 1];
    }

    public static void main(String[] args) {
        String leaves = "yry";
        System.out.println(minimumOperations(leaves));
    }
}
