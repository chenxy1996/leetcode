package dp._123_困难_买卖股票的最佳时机3;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[] {-prices[0], Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int i = 1; i < prices.length; i++) {
            if (i >= 3) {
                dp[3] = Math.max(dp[3], prices[i] + dp[2]); // 已经完成了一次交易后又交易了一笔
            }
            if (i >= 2) {
                dp[2] = Math.max(dp[2], dp[1] - prices[i]); // 已经完成了一次交易后又买了一笔
            }
            dp[1] = Math.max(dp[1], prices[i] + dp[0]); // 交易了第一笔
            dp[0] = Math.max(dp[0], -prices[i]); // 才买第一笔没抛
        }
        int ans = Math.max(Math.max(dp[0], dp[1]), Math.max(dp[2], dp[3]));
        return Math.max(0, ans); // 和完全没有买股票对比
    }
}
