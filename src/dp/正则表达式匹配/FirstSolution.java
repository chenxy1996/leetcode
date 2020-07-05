package dp.正则表达式匹配;

// 20200705 复盘
// 这道题和之前做过的一个正则表达式匹配基本一致。
// 之前做的可能忘记忘记了
// '?' 可以匹配任何单个字符。
// '*' 可以匹配任意字符串（包括空字符串）。

// s = "cb"
// p = "?a"
// 输出: false
// 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。

// s = "aa"
// p = "*"
// 输出: true
// 解释: '*' 可以匹配任意字符串。

// 动态规划 dp 解
public class FirstSolution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() != 0 && p.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[p.length()][s.length() + 1];
        for (int i = 0; i < p.length(); i++) {
            char pc = p.charAt(i);
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    if (pc == '*') {
                        if (i == 0) {
                            dp[i][0] = true;
                        } else {
                            dp[i][0] = dp[i - 1][0];
                        }
                    }
                } else {
                    if (pc == '?') {
                        if (i > 0) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            if (j == 1) {
                                dp[i][j] = true;
                            }
                        }
                    } else if (pc == '*') {
                        dp[i][j] = (i > 0 && dp[i - 1][j]) || // * 匹配空字符串
                                    dp[i][j - 1];
                    } else {
                        char sc = s.charAt(j - 1);
                        if (sc == pc) {
                            if (i > 0) {
                                dp[i][j] = dp[i - 1][j - 1];
                            } else {
                                if (j == 1) {
                                    dp[i][j] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return dp[p.length() - 1][s.length()];
    }

    public static void main(String[] args) {
        FirstSolution firstSolution = new FirstSolution();
        String s = "a";
        String p = "";
        System.out.println(firstSolution.isMatch(s, p));
    }
}
