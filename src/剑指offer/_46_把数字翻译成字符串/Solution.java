package 剑指offer._46_把数字翻译成字符串;

// 第一次做这道题目做得麻烦了
/**
 * 这道题和 dp 中的解码 ip 地址差不多，同样可以用动态规划来做
 */
public class Solution {
    public int translateNum(int num) {
        String s =  String.valueOf(num);
        int l = s.length();
        int[][] dp = new int[l + 1][l + 1];
        dp[0][0] = 1;
        int res = 0;
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < l + 1; j++) {
                dp[i][j] += dp[i - 1][j - 1];
                if (j - 2 >= 0) {
                    String substring = s.substring(j - 2, j);
                    if (substring.charAt(0) != '0' && Integer.parseInt(substring) <= 25) {
                        dp[i][j] += dp[i - 1][j - 2];
                    }
                }
            }
            res += dp[i][l];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.translateNum(506));
    }
}
