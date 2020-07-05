package jianZhiOffer._19hardhard_isMatch;

import java.util.Arrays;

public class Solution {
    // 用 dp 来做一下
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        // 初始化 dp 数组
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;


        for (int i = 1; i < dp.length; i++) {
            // pattern current char
            char pc = p.charAt(i - 1);

            for (int j = 0; j < dp[0].length; j++) {
                // 只有在 pc 为 * 时候判断第 0 项 是否为正确的
                if (j == 0 && pc == '*') {
                    dp[i][j] = dp[i - 2][j];
                }

                if (j >= 1) {
                    // string current char
                    char sc = s.charAt(j - 1);

                    // pc 在 a - z 范围中, 且此时 sc == pc
                    if (('a' <= pc && 'z' >= pc) && sc == pc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                    // pc 为 .
                    if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                    // pc 为 *
                    if (pc == '*') {
                        // 找到 * 的前一个字符
                        char prevChar = p.charAt(i - 2);

                        // 如果前一个字符在 a - z 范围中
                        if ('a' <= prevChar && 'z' >= prevChar) {
                            // 如果当前 sc == prevChar
                            if (sc == prevChar) {
                                dp[i][j] = dp[i - 2][j] || // 取零个字符
                                        dp[i - 1][j] || // 取一个字符
                                        dp[i][j - 1]; // 取多个字符;
                            } else {
                                // 当前 sc != prevChar
                                // 只能此处取零个字符了
                                dp[i][j] = dp[i - 2][j];
                            }
                        }

                        // 前一个字符为 .
                        if (prevChar == '.') {
                            dp[i][j] = dp[i - 2][j] || // 取零个字符
                                        dp[i - 1][j] || // 取一个字符
                                        dp[i][j - 1]; // 取多个字符;
                        }
                    }
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        String p = "..b*a*..*c";
        String s = "ccacacc";

        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));

    }
}
