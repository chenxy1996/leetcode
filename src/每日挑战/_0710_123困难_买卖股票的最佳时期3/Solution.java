package 每日挑战._0710_123困难_买卖股票的最佳时期3;

// 最多可以完成 两笔 交易。
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] dp;
        /*
         * dp:
         * [
         *  0：前一天结束后不持有股票且还有0次交易机会的最大收益，
         *  1：前一天结束后不持有股票且还有1次交易机会的最大收益，
         *  2：前一天结束后不持有股票且还有2次交易机会的最大收益，
         *  3：前一天结束后持有股票且还有0次交易机会的最大收益，
         *  4：前一天结束后持有股票且还有1次交易机会的最大收益
         * ]
         */
        // 初始化第一天
        dp = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, -prices[0]};
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int[] temp = new int[5];
            // 1. 当天结束后不持有任何股票
            for (int j = 0; j < 2; j++) {
                // 当天结束后不持有股票，且剩余交易次数为 j 的情况
                // 1.1 前一天结束后不持有股票，且剩余交易次数为 j ,当天不买时候的最大收益
                int profitNoPrice = dp[j];
                // 1.2 前一天结束后持有股票，且剩余交易次数为 j ,当天卖出股票时候的最大收益
                int profitHasPrice = dp[3 + j] == Integer.MIN_VALUE ?
                        Integer.MIN_VALUE : dp[3 + j] + price;
                temp[j] = Math.max(profitHasPrice, profitNoPrice);
            }
            // 前一天结束后不持有任何股票，且剩余交易次数为 2 的情况
            // 一直不买股票
            temp[2] = 0;
            // 2. 当天结束后持有股票
            for (int j = 0; j < 2; j++) {
                // 当天结束后持有股票，且剩余交易次数为 j 的情况
                // 2.1 当前一天结束后不持有股票，剩余交易次数为 j + 1, 当天买入股票时候的最大收益
                int profitNoPrice = dp[j + 1] == Integer.MIN_VALUE ?
                                   Integer.MIN_VALUE : dp[j + 1] - price;
                // 2.2 当前一天结束后持有股票，剩余交易次数为 j, 当天不卖出股票时候的最大收益
                int profitHasPrice = dp[3 + j];
                temp[3 + j] = Math.max(profitHasPrice, profitNoPrice);
            }
            dp = temp;
        }
        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] dp;
        dp = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, -prices[0]};
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int[] temp = new int[5];
            for (int j = 0; j < 2; j++) {
                int profitNoPrice = dp[j];
                int profitHasPrice = dp[3 + j] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[3 + j] + price;
                temp[j] = Math.max(profitHasPrice, profitNoPrice);
            }
            temp[2] = 0;
            for (int j = 0; j < 2; j++) {
                int profitNoPrice = dp[j + 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[j + 1] - price;
                int profitHasPrice = dp[3 + j];
                temp[3 + j] = Math.max(profitHasPrice, profitNoPrice);
            }
            dp = temp;
        }
        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(prices));
    }
}
