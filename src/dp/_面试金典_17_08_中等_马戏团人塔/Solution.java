package dp._面试金典_17_08_中等_马戏团人塔;

import java.util.Arrays;

public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] composite = new int[len][2];
        for (int i = 0; i < len; i++) {
            composite[i][0] = height[i];
            composite[i][1] = weight[i];
        }
        Arrays.sort(composite, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int[][] dp = new int[len][2];
        for (int[] ints : composite) {
            int p = find(dp, 0, ans - 1, ints[1]);
            dp[p] = ints;
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
//        int[] heights = {65,70,56,75,60,68};
//        int[] weights = {100,150,90,190,95,110};
//        System.out.println(new Solution().bestSeqAtIndex(heights, weights));

        int[] nums = {1, 2, 4, 4, 4, 7, 8, 8, 8, 10};
        int target = 3;
        System.out.println(Arrays.binarySearch(nums, target));
    }
}
