import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class Test {
    private static volatile boolean block = true;
    public static void main(String[] args) throws InterruptedException {
        String s = "10101";
        System.out.println(numWays(s));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for(int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (c1 == c2) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        int len = triangle.size();
        for(int i = 1; i < len; i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> lastRow = triangle.get(i - 1);
            for(int j = 0; j < row.size(); j++) {
                int val = row.get(j);
                if (j == 0) {
                    row.set(j, val + lastRow.get(0));
                } else if (j == lastRow.size()) {
                    row.set(j, val + lastRow.get(j - 1));
                } else {
                    row.set(j, val + Math.max(lastRow.get(j), lastRow.get(j - 1)));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int each : triangle.get(len - 1)) {
            ans = Math.max(each, ans);
        }
        return ans;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int len = envelopes.length;
        int[] dp = new int[len];
        int ans = 0;
        for(int i = 0; i < len; i++) {
            int[] e = envelopes[i];
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (e[0] > envelopes[j][0] && e[1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int numWays(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int mod = 1000000007;
        int len = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            cnt += c - '0';
            map.putIfAbsent(cnt, i);
        }
        if (cnt == 0) {
            return (len - 1) * (len - 2) / 2 % mod;
        }
        if (cnt % 3 != 0) {
            return 0;
        }
        int ave = cnt / 3;
        return (map.get(ave + 1) - map.get(ave)) * (map.get(2 * ave + 1) - map.get(2 * ave)) % mod;
    }
}
