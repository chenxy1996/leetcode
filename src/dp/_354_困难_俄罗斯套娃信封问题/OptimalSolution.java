package dp._354_困难_俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 这道题的关键是，对于宽度相同的信封，要按照高度降序排列
 */
public class OptimalSolution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        int ans = 0;
        int len = envelopes.length;
        int[][] dp = new int[len][2];
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] envelope : envelopes) {
            int h = envelope[1];
            int p = find(dp, 0, ans - 1, h);
            dp[p] = envelope;
            ans = Math.max(ans, p + 1);
        }
        return ans;
    }

    private static int find(int[][] dp, int i, int j, int target) {
        while (i <= j) {
            int m = (j - i) / 2 + i;
            if (dp[m][1] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[][] nums = {{4,5},{4,5},{6,7},{2,3},{1,1}};
//        int[][] nums = {{5,4},{6,4},{6,7},{2,3}};
//        int[][] nums = {{20,50},{12,2},{3,4},{12,15}};
        OptimalSolution os = new OptimalSolution();
        System.out.println(os.maxEnvelopes(nums));
    }
}
