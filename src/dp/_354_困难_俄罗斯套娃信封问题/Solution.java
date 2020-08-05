package dp._354_困难_俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int ans = 0;
        if (envelopes == null) {
            return ans;
        }
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        int len = envelopes.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
