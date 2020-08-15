package 剑指offer._0_剑指offer二刷_20200806._19_02_通配符匹配;

/**
 * 用滚动数组来
 */
public class OptimalSolution {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }

        int m = p.length();
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i <= m; i++) {
            boolean[] tmp = new boolean[n + 1];
            char pc = p.charAt(i - 1);
            for(int j = 0; j <= n; j++) {
                if (j == 0 && pc == '*') {
                    tmp[j] = dp[0];
                } else if (j > 0) {
                    char sc = s.charAt(j - 1);
                    if (pc == '?' || sc == pc) {
                        tmp[j] = dp[j - 1];
                    } else if (pc == '*') {
                        tmp[j] = dp[j] | tmp[j - 1];
                    }
                }
            }
            dp = tmp;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(isMatch(s, p));
    }
}
