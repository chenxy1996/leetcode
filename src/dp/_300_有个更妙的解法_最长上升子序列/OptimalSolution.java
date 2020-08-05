package dp._300_有个更妙的解法_最长上升子序列;

/**
 * 贪心和二分法
 */
public class OptimalSolution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            int p = find(dp, 0, ans - 1, val);
            dp[p] = val;
            ans = Math.max(p + 1, ans);
        }
        return ans;
    }

    private static int find(int[] nums, int i, int j, int target) {
        int l = i;
        int r = j;
        while (l <= r) {
            int m = ((r - l) >> 1) + l;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new OptimalSolution().lengthOfLIS(nums));
    }
}
