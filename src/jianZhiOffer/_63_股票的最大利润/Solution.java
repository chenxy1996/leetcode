package jianZhiOffer._63_股票的最大利润;

// 只能买卖一次
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        // dp[0]: 当天结束后没有股票的，且曾经买卖过股票得到的最大利润
        // dp[1]: 当天结束后持有股票的状况
        int[] dp = new int[]{prices[1] - prices[0], -(Math.min(prices[0], prices[1]))};
        for (int i = 2; i < prices.length; i++) {
            int price = prices[i];
            dp[0] = Math.max(dp[0], dp[1] + price);
            dp[1] = Math.max(dp[1], -price);
        }
        return dp[0] < 0 ? 0 : dp[0];
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(new Solution().maxProfit(prices));
    }
}
