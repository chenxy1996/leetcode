package dp._0983_我觉得挺难的_从后往前思考_最低票价;

import java.util.HashSet;
import java.util.Set;

/**
 * 这道题目要倒着来
 */
public class Solution {
    public static int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < days.length; i++) {
            set.add(days[i]);
        }
        int max = days[days.length - 1];
        int[] dp = new int[days[days.length - 1] + 1];
        for(int i = 1; i <= max; i++) {
            if (set.contains(i)) {
                int a = dp[i - 1] + costs[0];
                int b, c;
                if (i - 7 >= 0) {
                    b = dp[i - 7] + costs[1];
                } else {
                    b = costs[1];
                }
                if (i - 30 >= 0) {
                    c = dp[i - 30] + costs[2];
                } else {
                    c = costs[2];
                }
                dp[i] = Math.min(a, b);
                dp[i] = Math.min(dp[i], c);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
//        System.out.println((Arrays.binarySearch(days, 1)));
        int[] coins = {2,7,15};
        System.out.println(mincostTickets(days, coins));
    }
}
