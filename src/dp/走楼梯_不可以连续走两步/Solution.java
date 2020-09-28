package dp.走楼梯_不可以连续走两步;

/**
 * 走楼梯，可以一次走一步或者两步，不能连续走两次两部
 */
public class Solution {
    public static int allKindOfWays(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        dp1[1] = 1;
        dp2[1] = 0;
        dp1[0] = 1;
        for(int i = 2; i <= n; i++) {
            dp1[i] = dp1[i - 1] + dp2[i - 1];
            dp2[i] = dp1[i - 2];
        }
        return dp1[n] + dp2[n];
    }

    public static void main(String[] args) {
        System.out.println(allKindOfWays(3));
    }
}
