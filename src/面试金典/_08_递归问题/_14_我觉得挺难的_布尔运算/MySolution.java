package 面试金典._08_递归问题._14_我觉得挺难的_布尔运算;

public class MySolution {
    public int countEval(String s, int result) {
        int len = s.length();
        int[][][] dp = new int[len][len][2];
        for (int i = 0; i < s.length(); i += 2) {
            dp[i][i][s.charAt(i) - '0'] = 1;
        }
        for (int i = 2; i < len; i += 2) {
            for (int j = 0; j + i < len; j += 2) {
                int k = j + i; // 区间 [j, k]
                for (int m = j + 1; m < k; m += 2) {
                    // 左边区间 [j, m - 1], 右边区间 [m + 1, k]
                    char op = s.charAt(m);
                    if (op == '&') {
                        dp[j][k][0] += dp[j][m - 1][0] * (dp[m + 1][k][0] + dp[m + 1][k][1]) +
                                        dp[j][m - 1][1] * dp[m + 1][k][0];
                        dp[j][k][1] += dp[j][m - 1][1] * dp[m + 1][k][1];
                    } else if (op == '|') {
                        dp[j][k][1] += dp[j][m - 1][1] * (dp[m + 1][k][0] + dp[m + 1][k][1]) +
                                dp[j][m - 1][0] * dp[m + 1][k][1];
                        dp[j][k][0] += dp[j][m - 1][0] * dp[m + 1][k][0];
                    } else if (op == '^') {
                        dp[j][k][1] += dp[j][m - 1][0] * dp[m + 1][k][1] + dp[j][m - 1][1] * dp[m + 1][k][0];
                        dp[j][k][0] += dp[j][m - 1][0] * dp[m + 1][k][0] + dp[j][m - 1][1] * dp[m + 1][k][1];
                    }
                }
            }
        }
        return dp[0][len - 1][result];
    }

    public static void main(String[] args) {
        String s = "0&0&0&1^1|0";
        System.out.println(new MySolution().countEval(s, 1));
    }
}
