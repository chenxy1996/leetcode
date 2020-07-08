package jianZhiOffer._46_把数字翻译成字符串;

/**
 * 和青蛙条跳台阶问题差不多
 */
public class BetterSolution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int l = s.length();
        int[] dp = new int[l + 1];
        dp[0] = 1;
        for (int i = 1; i < l + 1; i++) {
            dp[i] += dp[i - 1];
            if (i - 2 >= 0) {
                String substring = s.substring(i - 2, i);
                if (substring.charAt(0) != '0' && Integer.parseInt(substring) <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[l];
    }

    public static void main(String[] args) {
        BetterSolution solution = new BetterSolution();
        System.out.println(solution.translateNum(506));
    }
}
