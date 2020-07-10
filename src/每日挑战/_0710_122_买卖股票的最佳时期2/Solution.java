package 每日挑战._0710_122_买卖股票的最佳时期2;

public class Solution {
    // 二维数组 dp
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 第二维数组第0项为当天交易结束后没有股票的收益的最大值
        // 第1项为当天交易结束后还持有股票的收益的最大值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            dp[i][0] = Math.max(
                    dp[i - 1][0], // 前一天结束后不持有股票
                    dp[i - 1][1] + price // 前一天结束后持有股票，那么卖掉所持股票
            );
            dp[i][1] = Math.max(
                    dp[i - 1][1], // 前一天结束后持有股票
                    dp[i - 1][0] - price //  前一天结束后不持有股票，那么买入当天股票
            );
        }
        return dp[n- 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
