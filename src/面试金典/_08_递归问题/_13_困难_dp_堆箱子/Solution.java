package 面试金典._08_递归问题._13_困难_dp_堆箱子;

import java.util.Arrays;

/**
 * 利用动态规划来解题
 */
public class Solution {
    public int pileBox(int[][] box) {
        int m = box.length;
        if (m == 0) {
            return 0;
        }
        Arrays.sort(box, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[m];
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] box = {
                {1,1,1},
                {2,3,4},
                {2,6,7},
                {3,4,5}
        };
        System.out.println(new Solution().pileBox(box));
    }
}
