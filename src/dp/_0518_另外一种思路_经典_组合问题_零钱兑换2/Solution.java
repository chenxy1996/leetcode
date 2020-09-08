package dp._0518_另外一种思路_经典_组合问题_零钱兑换2;

import java.util.Arrays;

public class Solution {
    public static int change(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[len + 1][amount + 1];
        for(int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= len; i++) {
            int notion = coins[i - 1];
            for(int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i - 1][j] + (j >= notion ? dp[i][j - notion] : 0);
            }
        }
        return dp[len][amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1 ,2, 5}));
    }
}
