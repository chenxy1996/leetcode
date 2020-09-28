package dp.买卖股票的最大利润;

public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
